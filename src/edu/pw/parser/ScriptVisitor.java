package edu.pw.parser;// Generated from Script.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScriptParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(ScriptParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(ScriptParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ScriptParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#instructionSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionSet(ScriptParser.InstructionSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ScriptParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ScriptParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatement(ScriptParser.DeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(ScriptParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#functionInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(ScriptParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(ScriptParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#numericOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericOperation(ScriptParser.NumericOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(ScriptParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(ScriptParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#singleOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleOperation(ScriptParser.SingleOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ScriptParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#alternative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternative(ScriptParser.AlternativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#cojunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCojunction(ScriptParser.CojunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#cojunctionOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCojunctionOperand(ScriptParser.CojunctionOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ScriptParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#singleCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleCondition(ScriptParser.SingleConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ScriptParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ScriptParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#integerAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerAtom(ScriptParser.IntegerAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(ScriptParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#textAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextAtom(ScriptParser.TextAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#idAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(ScriptParser.IdAtomContext ctx);
}