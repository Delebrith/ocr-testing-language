package edu.pw.main.parser.exception.type;

import edu.pw.main.parser.exception.InterpretingException;

public class InvalidAssignmentTypeException extends InterpretingException {
    public InvalidAssignmentTypeException(String message) {
        super(message);
    }
}
