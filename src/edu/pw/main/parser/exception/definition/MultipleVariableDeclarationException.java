package edu.pw.main.parser.exception.definition;

import edu.pw.main.parser.exception.InterpretingException;

public class MultipleVariableDeclarationException extends InterpretingException {
    public MultipleVariableDeclarationException(String message) {
        super(message);
    }
}
