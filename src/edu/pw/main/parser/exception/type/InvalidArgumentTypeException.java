package edu.pw.main.parser.exception.type;

import edu.pw.main.parser.exception.InterpretingException;

public class InvalidArgumentTypeException extends InterpretingException {
    public InvalidArgumentTypeException(String message) {
        super(message);
    }
}
