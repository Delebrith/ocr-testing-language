package edu.pw.parser;

import edu.pw.parser.exception.InvalidTypeException;

public class Variable implements Comparable<Variable> {
    private Type type;
    private String value;

    public Variable(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Variable getEmpty(){
        return new Variable(Type.VOID, "");
    }

    @Override
    public int compareTo(Variable v) {
        if (!this.getType().equals(v.getType()))
            throw new InvalidTypeException();
        if (this.getValue().equals(v.getValue()))
            return 0;
        if (this.getType().equals(Type.INTEGER)){
            return Integer.compare(Integer.valueOf(this.getValue()), Integer.valueOf(v.getValue()));
        } else {
            throw new InvalidTypeException();
        }
    }
}
