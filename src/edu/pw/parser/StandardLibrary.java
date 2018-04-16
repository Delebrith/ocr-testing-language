package edu.pw.parser;

import edu.pw.parser.exception.FileException;
import edu.pw.parser.exception.InvalidFunctionInvocationException;
import edu.pw.parser.exception.InvalidTypeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class StandardLibrary {

    private static InterpretingVisitor visitor;

    public StandardLibrary(InterpretingVisitor visitor) {
        this.visitor = visitor;
    }

    public Variable executePrint(ScriptParser.ArgumentsContext context){
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException();
        Variable variable = visitor.visitValue(context.value(0));
        if (variable.getType().equals(Type.IMAGE) || variable.getType().equals(Type.VOID))
            throw new InvalidTypeException();
        System.out.println(variable.getValue());
        return Variable.getEmpty();
    }

    public Variable executeToText(ScriptParser.ArgumentsContext context){
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException();
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.IMAGE) || variable.getType().equals(Type.VOID))
            throw new InvalidTypeException();
        return new Variable(Type.TEXT, variable.getValue());
    }

    public Variable executeLoadImage(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException();
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.TEXT)){
            try {
                byte[] content = Files.readAllBytes(Paths.get(variable.getValue()));
            } catch (IOException e) {
                throw new FileException();
            }
            return new Variable(Type.IMAGE, variable.getValue());
        } else {
            throw new InvalidTypeException();
        }
    }

    public Variable executeLoadText(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException();
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.TEXT)){
            byte[] content = new byte[0];
            try {
                content = Files.readAllBytes(Paths.get(variable.getValue()));
            } catch (IOException e) {
                throw new FileException();
            }
            return new Variable(Type.TEXT, content.toString());
        } else {
            throw new InvalidTypeException();
        }
    }

    public Variable executeCountWords(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException();
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.TEXT)){
            Random random = new Random();
            return new Variable(Type.INTEGER, String.valueOf(random.nextInt(60)));
        } else {
            throw new InvalidTypeException();
        }
    }

    public Variable executeCountParagraphs(ScriptParser.ArgumentsContext context){
        return executeCountWords(context);
    }

    public Variable executeCompare(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 2)
            throw new InvalidFunctionInvocationException();
        Variable v1 = visitor.visit(context.value(0));
        Variable v2 = visitor.visit(context.value(1));
        if (v1.getType().equals(Type.TEXT) && v2.getType().equals(Type.TEXT)){
            Random random = new Random();
            return new Variable(Type.INTEGER, String.valueOf(random.nextInt(100)));
        } else {
            throw new InvalidTypeException();
        }
    }

    public Variable executeOcr(ScriptParser.ArgumentsContext context){
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException();
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.IMAGE)){
            Random random = new Random();
            return new Variable(Type.TEXT, "text of image from: " + variable.getValue());
        } else {
            throw new InvalidTypeException();
        }
    }

    public Variable executeStandard(String functionId, ScriptParser.FunctionInvocationContext ctx) {
        if (functionId.equals(StandardFunction.PRINT.getId())){
            return executePrint(ctx.arguments());
        } else if (functionId.equals(StandardFunction.TO_TEXT.getId())){
            return executeToText(ctx.arguments());
        } else if (functionId.equals(StandardFunction.LOAD_IMAGE.getId())){
            return executeLoadImage(ctx.arguments());
        } else if (functionId.equals(StandardFunction.LOAD_TEXT.getId())) {
            return executeLoadText(ctx.arguments());
        } else if (functionId.equals(StandardFunction.COUNT_WORDS.getId())){
            return executeCountWords(ctx.arguments());
        } else if (functionId.equals(StandardFunction.COUNT_PARAGRAPHS.getId())){
            return executeCountParagraphs(ctx.arguments());
        } else if (functionId.equals(StandardFunction.COMPARE.getId())) {
            return executeCompare(ctx.arguments());
        } else if (functionId.equals(StandardFunction.OCR.getId())){
            return executeOcr(ctx.arguments());
        } else {
            return null;
        }
    }

}
