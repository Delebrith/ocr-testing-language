package edu.pw.parser.exception.definition;

import edu.pw.parser.exception.InterpretingException;

public class MultipleFunctionDefinitionException extends InterpretingException {
    public MultipleFunctionDefinitionException(String message) {
        super(message);
    }
}
