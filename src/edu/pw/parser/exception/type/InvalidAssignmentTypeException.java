package edu.pw.parser.exception.type;

import edu.pw.parser.exception.InterpretingException;

public class InvalidAssignmentTypeException extends InterpretingException {
    public InvalidAssignmentTypeException(String message) {
        super(message);
    }
}
