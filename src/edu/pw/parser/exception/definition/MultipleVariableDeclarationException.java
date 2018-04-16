package edu.pw.parser.exception.definition;

import edu.pw.parser.exception.InterpretingException;

public class MultipleVariableDeclarationException extends InterpretingException {
    public MultipleVariableDeclarationException(String message) {
        super(message);
    }
}
