package edu.pw.test.parser;

import edu.pw.main.lexer.ScriptLexer;
import edu.pw.main.parser.InterpretingVisitor;
import edu.pw.main.parser.Type;
import edu.pw.main.parser.Variable;
import edu.pw.main.parser.exception.InvalidFunctionInvocationException;
import edu.pw.main.parser.exception.definition.FunctionUndefinedException;
import edu.pw.main.parser.exception.definition.MultipleVariableDeclarationException;
import edu.pw.main.parser.exception.definition.MultipleFunctionDefinitionException;
import edu.pw.main.parser.exception.type.InvalidArgumentTypeException;
import edu.pw.main.parser.exception.type.InvalidAssignmentTypeException;
import edu.pw.main.parser.exception.type.InvalidReturnTypeException;
import edu.pw.main.parser.exception.FileException;
import edu.pw.main.parser.generated.ScriptParser;
import org.antlr.v4.runtime.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class InterpretingVisitorTest {

    InterpretingVisitor visitor;
    ScriptParser scriptParser;

    @Before
    public void init() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/test.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
    }


    @Test
    public void visitFunctionDefinition() throws IOException {
        //when
        visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getFunctionDefinitionContextHashMap().containsKey("result"));
        assertTrue(visitor.getFunctionDefinitionContextHashMap().containsKey("addition"));
        assertTrue(visitor.getFunctionDefinitionContextHashMap().containsKey("main"));
    }

    @Test
    public void visitIfStatement() throws IOException {
        //when
        visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().containsKey("testIfStatement"));
        assertTrue(visitor.getScopeStack().peek().get("testIfStatement").getValue().equals("1"));
    }

    @Test
    public void visitWhileStatement() throws IOException {
        //when
        visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().containsKey("testWhileStatement"));
        assertTrue(visitor.getScopeStack().peek().get("testWhileStatement").getValue().equals("10"));
    }

    @Test
    public void visitReturnStatement() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testReturnStatement").getValue().equals("2"));
    }

    @Test
    public void visitDeclarationStatement() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().containsKey("testDeclarationStatement"));
    }

    @Test
    public void visitAssignmentStatement() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testDeclarationStatement").getValue().equals("test"));
    }

    @Test
    public void visitSum() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testSum").getValue().equals("2"));
    }

    @Test
    public void visitMultiplication() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testMultiplication1").getValue().equals("6"));
        assertTrue(visitor.getScopeStack().peek().get("testMultiplication2").getValue().equals("6"));
    }

    @Test
    public void visitCondition() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testCondition").getType().equals(Type.BOOLEAN));
        assertTrue(visitor.getScopeStack().peek().get("testCondition").getValue().equals("true"));
    }

    @Test
    public void visitAlternative() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testAlternative").getType().equals(Type.BOOLEAN));
        assertTrue(visitor.getScopeStack().peek().get("testAlternative").getValue().equals("true"));
    }

    @Test
    public void visitCojunction() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testCojunction").getType().equals(Type.BOOLEAN));
        assertTrue(visitor.getScopeStack().peek().get("testCojunction").getValue().equals("false"));
    }

    @Test
    public void visitComparison() {
        //when
        Variable result = visitor.visit(scriptParser.script());
        //then
        assertTrue(visitor.getScopeStack().peek().get("testComparison").getType().equals(Type.BOOLEAN));
        assertTrue(visitor.getScopeStack().peek().get("testComparison").getValue().equals("true"));
    }

    @Test(expected = FileException.class)
    public void loadFile() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/fileExceptionTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = FunctionUndefinedException.class)
    public void functionUndefinedTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/FunctionUndefinedTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = MultipleFunctionDefinitionException.class)
    public void multipleFunctionDefinitionTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/MultipleFunctionDefinitionTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = MultipleVariableDeclarationException.class)
    public void multipleVariableDeclarationTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/MultipleVariableDeclarationTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = InvalidArgumentTypeException.class)
    public void invalidArgumentTypeTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/InvalidArgumentTypeTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = InvalidAssignmentTypeException.class)
    public void invalidAssignmentTypeTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/InvalidAssignmentTypeTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = InvalidReturnTypeException.class)
    public void invalidReturnTypeTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/InvalidReturnTypeTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }

    @Test(expected = InvalidFunctionInvocationException.class)
    public void invalidFunctionInvocationTest() throws IOException {
        //given
        CharStream charStream = CharStreams.fromFileName("examples/InvalidFunctionInvocationTest.txt");
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        scriptParser = new ScriptParser(tokenStream);

        visitor = new InterpretingVisitor();
        //when
        visitor.visit(scriptParser.script());
    }
}