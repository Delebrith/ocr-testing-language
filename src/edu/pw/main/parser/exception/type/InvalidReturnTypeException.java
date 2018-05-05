package edu.pw.main.parser.exception.type;

import edu.pw.main.parser.exception.InterpretingException;

public class InvalidReturnTypeException extends InterpretingException {
    public InvalidReturnTypeException(String message) {
        super(message);
    }
}
