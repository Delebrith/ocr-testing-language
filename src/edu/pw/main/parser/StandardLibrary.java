package edu.pw.main.parser;

import edu.pw.main.parser.exception.type.InvalidArgumentTypeException;
import edu.pw.main.parser.generated.ScriptParser;
import edu.pw.main.parser.exception.FileException;
import edu.pw.main.parser.exception.InvalidFunctionInvocationException;

import java.io.IOException;
import java.nio.charset.Charset;
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
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function countWords requires one argument of type TEXT, INTEGER or BOOLEAN");
        Variable variable = visitor.visitValue(context.value(0));
        if (variable.getType().equals(Type.IMAGE) || variable.getType().equals(Type.VOID))
            throw new InvalidArgumentTypeException("Cannot perform print operation on type: " +
                    variable.getType());
        System.out.println(variable.getValue());
        return Variable.getEmpty();
    }

    public Variable executeToText(ScriptParser.ArgumentsContext context){
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function toText requires one argument of type TEXT, INTEGER or BOOLEAN");
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.IMAGE) || variable.getType().equals(Type.VOID))
            throw new InvalidArgumentTypeException("Cannot perform toText operation on type: " +
            variable.getType());
        return new Variable(Type.TEXT, variable.getValue());
    }

    public Variable executeLoadImage(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function loadImage requires one argument of type TEXT");
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.TEXT)){
            byte[] content;
            try {
                content = Files.readAllBytes(Paths.get(variable.getValue()));
            } catch (IOException e) {
                throw new FileException("Cannot read file: " + variable.getValue() +
                        " or file does not exist.");
            }
            return new Variable(Type.IMAGE, variable.getValue(), content);
        } else {
            throw new InvalidArgumentTypeException("Load image operation cannot be performed on type: " + variable.getType() +
                    ". Argument type should be " + Type.TEXT + " and should contain a valid path to file.");
        }
    }

    public Variable executeLoadText(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function loadText requires one argument of type TEXT");
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.TEXT)){
            byte[] content;
            try {
                content = Files.readAllBytes(Paths.get(variable.getValue()));
            } catch (IOException e) {
                throw new FileException("Cannot read file: " + variable.getValue() +
                " or file does not exist.");
            }
            return new Variable(Type.TEXT, new String(content, Charset.forName("UTF-8")), content);
        } else {
            throw new InvalidArgumentTypeException("LoadText operation cannot be performed on type: " + variable.getType() +
                    ". Argument type should be " + Type.TEXT + " and contain valid path to file.");
        }
    }

    public Variable executeCountWords(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function countWords requires one argument of type TEXT");
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.TEXT)){
            Random random = new Random();
            return new Variable(Type.INTEGER, String.valueOf(random.nextInt(60)));
        } else {
            throw new InvalidArgumentTypeException("Count words operation cannot be performed on type: " + variable.getType() +
            ". Argument type should be " + Type.TEXT );
        }
    }

    public Variable executeCountParagraphs(ScriptParser.ArgumentsContext context){
        return executeCountWords(context);
    }

    public Variable executeCompare(ScriptParser.ArgumentsContext context) {
        if (context.value().size() != 2)
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function compare requires two argument of type TEXT");
        Variable v1 = visitor.visit(context.value(0));
        Variable v2 = visitor.visit(context.value(1));
        if (v1.getType().equals(Type.TEXT) && v2.getType().equals(Type.TEXT)){
            Random random = new Random();
            return new Variable(Type.INTEGER, String.valueOf(random.nextInt(100)));
        } else {
            throw new InvalidArgumentTypeException("Cannot perform ocr quality comparison on types: "
                    + v1.getType() + " and " + v2.getType());
        }
    }

    public Variable executeOcr(ScriptParser.ArgumentsContext context){
        if (context.value().size() != 1)
            throw new InvalidFunctionInvocationException("Wrong number of arguments. " +
                    "Function ocr requires one argument of type IMAGE");
        Variable variable = visitor.visit(context.value(0));
        if (variable.getType().equals(Type.IMAGE)){
            Random random = new Random();
            return new Variable(Type.TEXT, "text of image from: " + variable.getValue());
        } else {
            throw new InvalidArgumentTypeException("Cannot perform ocr on type " + variable.getType() +
            ". Argument type should be " + Type.IMAGE);
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
