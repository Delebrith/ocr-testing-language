package edu.pw.parser.exception.definition;

import edu.pw.parser.exception.InterpretingException;

public class VariableUndeclaredException extends InterpretingException {
    public VariableUndeclaredException(String message) {
        super(message);
    }
}
