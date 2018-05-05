package edu.pw.main.parser.exception.definition;

import edu.pw.main.parser.exception.InterpretingException;

public class VariableUndeclaredException extends InterpretingException {
    public VariableUndeclaredException(String message) {
        super(message);
    }
}
