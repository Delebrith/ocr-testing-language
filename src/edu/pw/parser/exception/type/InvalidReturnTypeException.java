package edu.pw.parser.exception.type;

import edu.pw.parser.exception.InterpretingException;

public class InvalidReturnTypeException extends InterpretingException {
    public InvalidReturnTypeException(String message) {
        super(message);
    }
}
