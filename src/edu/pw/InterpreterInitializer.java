package edu.pw;

import edu.pw.lexer.ScriptLexer;
import edu.pw.parser.InterpretingVisitor;
import edu.pw.parser.generated.ScriptParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class InterpreterInitializer {



    public static void generateTreeView(String pathToScript) throws IOException {
        CharStream charStream = CharStreams.fromFileName(pathToScript);
        ScriptLexer languageLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(languageLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        ScriptParser scriptParser = new ScriptParser(tokenStream);
//        show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(scriptParser.getRuleNames()),scriptParser.script());
        panel.add(viewer);
        frame.add(new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public static void execute(String pathToScript) throws IOException {
        CharStream charStream = CharStreams.fromFileName(pathToScript);
        ScriptLexer scriptLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(scriptLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        ScriptParser scriptParser = new ScriptParser(tokenStream);

        InterpretingVisitor visitor = new InterpretingVisitor();
        visitor.visit(scriptParser.script());
    }
}
