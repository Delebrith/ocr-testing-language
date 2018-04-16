package edu.pw.parser.exception.definition;

import edu.pw.parser.exception.InterpretingException;

public class FunctionUndefinedException extends InterpretingException {
    public FunctionUndefinedException(String message) {
        super(message);
    }
}
