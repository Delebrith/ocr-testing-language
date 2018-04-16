package edu.pw.parser;

import edu.pw.parser.exception.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class InterpretingVisitor extends ScriptBaseVisitor<Variable> {

    private final HashMap<String, ScriptParser.FunctionDefinitionContext> functionDefinitionContextHashMap;
    private final Stack<HashMap<String, Variable>> scopeStack;
    private final StandardLibrary standardLibrary;

    public InterpretingVisitor() {
        scopeStack = new Stack<>();
        scopeStack.push(new HashMap<>());
        functionDefinitionContextHashMap = new HashMap<>();
        standardLibrary = new StandardLibrary(this);
    }

    @Override
    public Variable visitScript(ScriptParser.ScriptContext ctx) {
        for (ScriptParser.FunctionDefinitionContext definition : ctx.functionDefinition()) {
            functionDefinitionContextHashMap.put(definition.ID().getText(), definition);
        }
        return visit(functionDefinitionContextHashMap.get("main"));
    }

    @Override
    public Variable visitFunctionDefinition(ScriptParser.FunctionDefinitionContext ctx) {
        Variable result = visitInstructionSet(ctx.instructionSet());
        if (result == null) result = Variable.getEmpty();
        if (!result.getType().equals(Type.valueOf(ctx.TYPE().getText().toUpperCase())))
            throw new InvalidReturnTypeException("Function: " + ctx.ID().getText() + " returns value of type: " +
            String.valueOf(result.getType()) + ". Should return: " + ctx.TYPE().getText());
        return result;
    }

    public Variable visitParameters(ScriptParser.ParametersContext ctx, HashMap<String, Variable> scope) {
        for(int i = 0; i < ctx.ID().size(); i++){
            scope.put(ctx.ID(i).getText(), new Variable(Type.valueOf(ctx.TYPE(i).getText().toUpperCase()), ""));
        }
        return null;
    }

    @Override
    public Variable visitInstructionSet(ScriptParser.InstructionSetContext ctx) {
        for (int i = 0; i < ctx.statement().size(); i++){
            if (ctx.statement(i).returnStatement() != null) {
                Variable result = visitReturnStatement(ctx.statement(i).returnStatement());
                return result;
            }
            Variable result = visitStatement(ctx.statement(i));
            if (result != null && result.getType() != Type.VOID) return result;
        }
        return null;
    }

    @Override
    public Variable visitStatement(ScriptParser.StatementContext ctx) {
        if (ctx.ifStatement() != null) return visitIfStatement(ctx.ifStatement());
        if (ctx.whileStatement() != null) return visitWhileStatement(ctx.whileStatement());
        if (ctx.declarationStatement() != null) return visitDeclarationStatement(ctx.declarationStatement());
        if (ctx.assignmentStatement() != null) return visitAssignmentStatement(ctx.assignmentStatement());
        if (ctx.functionInvocation() != null) return visitFunctionInvocation(ctx.functionInvocation());
        if (ctx.returnStatement() != null) return visitReturnStatement(ctx.returnStatement());
        return null;
    }

    @Override
    public Variable visitIfStatement(ScriptParser.IfStatementContext ctx) {
        for (int i = 0; i < ctx.condition().size(); i++){
            if (visitCondition(ctx.condition(i)).getValue().equals(BooleanValue.TRUE.getValue())){
                return visitInstructionSet(ctx.instructionSet(i));
            }
        }
        if (ctx.ELSE() != null)
            return visitInstructionSet(ctx.instructionSet(ctx.instructionSet().size()-1));
        return null;
    }

    @Override
    public Variable visitWhileStatement(ScriptParser.WhileStatementContext ctx) {
        while (visitCondition(ctx.condition()).getValue().equals(BooleanValue.TRUE.getValue())){
           Variable result = visitInstructionSet(ctx.instructionSet());
           if (result != null) return result;
        }
        return null;
    }

    @Override
    public Variable visitReturnStatement(ScriptParser.ReturnStatementContext ctx) {
        return visitValue(ctx.value());
    }

    @Override
    public Variable visitDeclarationStatement(ScriptParser.DeclarationStatementContext ctx) {
        if (scopeStack.peek().containsKey(ctx.ID().getText()))
            throw new VariableAlreadyDeclaredException();
        Variable value = new Variable(Type.valueOf(ctx.TYPE().getText().toUpperCase()), "");
        if (ctx.value() != null) {
            Variable assigned = visitValue(ctx.value());
            if (!value.getType().equals(assigned.getType()))
                throw new InvalidTypeException();
            value.setValue(assigned.getValue());
        }
        scopeStack.peek().put(ctx.ID().getText(), value);
        return null;
    }

    @Override
    public Variable visitAssignmentStatement(ScriptParser.AssignmentStatementContext ctx) {
        if (!scopeStack.peek().containsKey(ctx.ID().getText()))
            throw new VariableUndeclaredException("Variable of name: " + ctx.ID().getText() + " was used without previous declaration");
        Variable value = visit(ctx.value());
        if (!scopeStack.peek().get(ctx.ID().getText()).getType().equals(value.getType()))
            throw new InvalidTypeException();
        scopeStack.peek().get(ctx.ID().getText()).setValue(value.getValue());
        return null;
    }

    @Override
    public Variable visitFunctionInvocation(ScriptParser.FunctionInvocationContext ctx) {
        String functionId = ctx.ID().getText();

        if (StandardFunction.isStandard(functionId))
            return standardLibrary.executeStandard(functionId, ctx);

        if (!functionDefinitionContextHashMap.containsKey(ctx.ID().getText()))
            throw new FunctionUndefinedException();
        ScriptParser.FunctionDefinitionContext definitionContext =
                functionDefinitionContextHashMap.get(ctx.ID().getText());
        HashMap<String, Variable> newScope = new HashMap<>();
        visitParameters(definitionContext.parameters(), newScope);
        visitArguments(ctx.arguments(), definitionContext.parameters(), newScope);
        scopeStack.push(newScope);
        Variable result = visitFunctionDefinition(definitionContext);
        scopeStack.pop();
        if (result == null) return Variable.getEmpty();
        return result;
    }

    public Variable visitArguments(ScriptParser.ArgumentsContext argumentsContext, ScriptParser.ParametersContext parametersContext,
                                   HashMap<String, Variable> scope) {
        if (argumentsContext.value().size() != parametersContext.ID().size())
            throw new InvalidFunctionInvocationException();
        for (int i = 0; i < argumentsContext.value().size(); i++){
            Variable argument = scope.get(parametersContext.ID(i).getText());
            if (!argument.getType().equals(visitValue(argumentsContext.value(i)).getType()))
                throw new InvalidTypeException();
            argument.setValue(visitValue(argumentsContext.value(i)).getValue());
        }
        return null;
    }

    @Override
    public Variable visitNumericOperation(ScriptParser.NumericOperationContext ctx) {
        return super.visitSum(ctx.sum());
    }

    @Override
    public Variable visitSum(ScriptParser.SumContext ctx) {
        Variable result = visit(ctx.getChild(0)) ;
        for (int i = 1; i < ctx.children.size(); i += 2) {
            Variable part = visit(ctx.getChild(i+1));
            String operator = ctx.getChild(i) == null ? "" : ctx.getChild(i).getText();
            if (result.getType().equals(Type.INTEGER)) {
                switch (operator) {
                    case "+":
                        if (!part.getType().equals(Type.INTEGER))
                            throw new InvalidTypeException();
                        result.setValue(String.valueOf(Integer.valueOf(result.getValue()) + Integer.valueOf(part.getValue())));
                        break;
                    case "-":
                        if (!part.getType().equals(Type.INTEGER))
                            throw new InvalidTypeException();
                        result.setValue(String.valueOf(Integer.valueOf(result.getValue()) - Integer.valueOf(part.getValue())));
                        break;
                }
            } else if (result.getType().equals(Type.TEXT)){
                switch (operator) {
                    case "+":
                        if (part.getType().equals(Type.INTEGER) || part.getType().equals(Type.TEXT))
                            result.setValue(new String(result.getValue() + part.getValue()));
                        else
                            throw new InvalidTypeException();
                        break;
                    case "-":
                        throw new InvalidOperatorException();
                }
            }
        }
        return result;
    }

    @Override
    public Variable visitMultiplication(ScriptParser.MultiplicationContext ctx) {
        Variable result = visit(ctx.getChild(0));
        for (int i = 1; i < ctx.children.size(); i += 2) {
            Variable part = visit(ctx.getChild(i+1));
            if (!part.getType().equals(Type.INTEGER))
                throw new InvalidTypeException();
            String operator = ctx.getChild(i) == null ? "" : ctx.getChild(i).getText();
            switch (operator){
                case "*":
                    result.setValue(String
                            .valueOf(Integer.valueOf(result.getValue()) * Integer.valueOf(part.getValue())));
                    break;
                case "/":
                    result.setValue(String
                            .valueOf(Integer.valueOf(result.getValue()) / Integer.valueOf(part.getValue())));
                    break;
            }
        }
        return result;
    }

    @Override
    public Variable visitSingleOperation(ScriptParser.SingleOperationContext ctx) {
        Variable internalResult;
        if (null != ctx.MINUS_OP()) {
            internalResult = super.visit(ctx.getChild(1));
            if (!internalResult.getType().equals(Type.INTEGER))
                throw new InvalidTypeException();
            internalResult.setValue(
                    String.valueOf(-1 * Integer.valueOf(internalResult.getValue())));
        } else {
            internalResult = super.visit(ctx.getChild(0));
            if (!internalResult.getType().equals(Type.INTEGER) && !internalResult.getType().equals(Type.TEXT))
                throw new InvalidTypeException();
        }
        return internalResult;
    }

    @Override
    public Variable visitCondition(ScriptParser.ConditionContext ctx) {
        return visitAlternative(ctx.alternative());
    }

    @Override
    public Variable visitAlternative(ScriptParser.AlternativeContext ctx) {
        Boolean result = false;
        for (int i = 0; i < ctx.children.size(); i += 2) {
            Variable part = visit(ctx.getChild(i));
            if (!part.getType().equals(Type.BOOLEAN))
                throw new InvalidTypeException();
            result = result || (part.getValue().equals(BooleanValue.TRUE.getValue()) ? true : false);
        }
        return new Variable(Type.BOOLEAN, result ? BooleanValue.TRUE.getValue() : BooleanValue.FALSE.getValue());
    }

    @Override
    public Variable visitCojunction(ScriptParser.CojunctionContext ctx) {
        Boolean result = true;
        for (int i = 0; i < ctx.children.size(); i += 2) {
            Variable part = visit(ctx.getChild(i));
            if (!part.getType().equals(Type.BOOLEAN))
                throw new InvalidTypeException();
            result = result && (part.getValue().equals(BooleanValue.TRUE.getValue()) ? true : false);
        }
        return new Variable(Type.BOOLEAN, result ? BooleanValue.TRUE.getValue() : BooleanValue.FALSE.getValue());
    }

    @Override
    public Variable visitCojunctionOperand(ScriptParser.CojunctionOperandContext ctx) {
        return super.visitCojunctionOperand(ctx);
    }

    @Override
    public Variable visitComparison(ScriptParser.ComparisonContext ctx) {
        Variable operand1 = visit(ctx.getChild(0));
        Variable operand2 = visit(ctx.getChild(2));
        Integer comparisonResult = operand1.compareTo(operand2);
        String operator  = ctx.COMPARISON_OP().getSymbol().getText();
        switch (operator){
            case "<":
                return  comparisonResult == -1 ?
                        new Variable(Type.BOOLEAN, BooleanValue.TRUE.getValue())
                        : new Variable(Type.BOOLEAN, BooleanValue.FALSE.getValue());
            case "<=":
                return (comparisonResult == -1 || comparisonResult == 0) ?
                        new Variable(Type.BOOLEAN, BooleanValue.TRUE.getValue())
                        : new Variable(Type.BOOLEAN, BooleanValue.FALSE.getValue());
            case ">":
                return (comparisonResult == 1) ?
                        new Variable(Type.BOOLEAN, BooleanValue.TRUE.getValue())
                        : new Variable(Type.BOOLEAN, BooleanValue.FALSE.getValue());
            case ">=":
                return (comparisonResult == 1 || comparisonResult == 0) ?
                        new Variable(Type.BOOLEAN, BooleanValue.TRUE.getValue())
                        : new Variable(Type.BOOLEAN, BooleanValue.FALSE.getValue());
            case "==":
                return (comparisonResult == 0) ?
                        new Variable(Type.BOOLEAN, BooleanValue.TRUE.getValue())
                        : new Variable(Type.BOOLEAN, BooleanValue.FALSE.getValue());
            case "!=":
                return (comparisonResult != -1 || comparisonResult == 0) ?
                        new Variable(Type.BOOLEAN, BooleanValue.TRUE.getValue())
                        : new Variable(Type.BOOLEAN, BooleanValue.FALSE.getValue());
        }
        return null;
    }

    @Override
    public Variable visitSingleCondition(ScriptParser.SingleConditionContext ctx) {
        Variable internalResult;
        if (null != ctx.NEGATION_OP()) {
            internalResult = visit(ctx.getChild(1));
            if (!internalResult.getType().equals(Type.BOOLEAN))
                throw new InvalidTypeException();
            if (internalResult.getValue().equals(BooleanValue.TRUE.getValue())) {
                internalResult.setValue(BooleanValue.FALSE.getValue());
            } else {
                internalResult.setValue(BooleanValue.TRUE.getValue());
            }
        } else {
            internalResult = visit(ctx.getChild(0));
            if (!internalResult.getType().equals(Type.BOOLEAN))
                throw new InvalidTypeException();
        }
        return internalResult;
    }

    @Override
    public Variable visitValue(ScriptParser.ValueContext ctx) {
        return super.visitValue(ctx);
    }

    @Override
    public Variable visitAtom(ScriptParser.AtomContext ctx) {
        return super.visitAtom(ctx);
    }

    @Override
    public Variable visitIntegerAtom(ScriptParser.IntegerAtomContext ctx) {
        return new Variable(Type.INTEGER, ctx.getText());
    }

    @Override
    public Variable visitBooleanAtom(ScriptParser.BooleanAtomContext ctx) {
        return new Variable(Type.BOOLEAN, ctx.getText());
    }

    @Override
    public Variable visitTextAtom(ScriptParser.TextAtomContext ctx) {
        return new Variable(Type.TEXT,
                ctx.TEXT_VARIABLE().getText().substring(1, ctx.TEXT_VARIABLE().getText().length()-1));
    }

    @Override
    public Variable visitIdAtom(ScriptParser.IdAtomContext ctx) {
        if (!scopeStack.peek().containsKey(ctx.ID().getText()))
            throw new VariableUndeclaredException("Variable of name: " + ctx.ID().getText() + " was used without previous declaration");
        return scopeStack.peek().get(ctx.ID().getText());
    }


}
