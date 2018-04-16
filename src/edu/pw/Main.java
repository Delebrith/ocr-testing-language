package edu.pw;

import edu.pw.lexer.ScriptLexer;
import edu.pw.parser.InterpretingVisitor;
import edu.pw.parser.generated.ScriptParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        CharStream charStream = CharStreams.fromFileName("examples/example5.txt");
        ScriptLexer languageLexer = new ScriptLexer(charStream);
        TokenSource tokenSource = new ListTokenSource(languageLexer.getAllTokens());
        TokenStream tokenStream = new CommonTokenStream(tokenSource);
        ScriptParser languageParser = new ScriptParser(tokenStream);

//        show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(languageParser.getRuleNames()),languageParser.script());
        viewr.setScale(1.5);//scale a little
        panel.add(viewr);
        frame.add(new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);

        CharStream charStream2 = CharStreams.fromFileName("examples/example5.txt");
        ScriptLexer languageLexer2 = new ScriptLexer(charStream2);
        TokenSource tokenSource2 = new ListTokenSource(languageLexer2.getAllTokens());
        TokenStream tokenStream2 = new CommonTokenStream(tokenSource2);
        ScriptParser languageParser2 = new ScriptParser(tokenStream2);

        InterpretingVisitor visitor = new InterpretingVisitor();
        visitor.visit(languageParser2.script());
    }
}
