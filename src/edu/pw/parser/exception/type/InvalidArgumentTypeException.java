package edu.pw.parser.exception.type;

import edu.pw.parser.exception.InterpretingException;

public class InvalidArgumentTypeException extends InterpretingException {
    public InvalidArgumentTypeException(String message) {
        super(message);
    }
}
