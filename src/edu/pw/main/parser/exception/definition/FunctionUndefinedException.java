package edu.pw.main.parser.exception.definition;

import edu.pw.main.parser.exception.InterpretingException;

public class FunctionUndefinedException extends InterpretingException {
    public FunctionUndefinedException(String message) {
        super(message);
    }
}
