package edu.pw.main.parser;


import edu.pw.main.parser.exception.type.InvalidArgumentTypeException;

public class Variable implements Comparable<Variable> {
    private Type type;
    private String value;
    private byte[] content;

    public Variable(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Variable(Type type, String value, byte[] content) {
        this.type = type;
        this.value = value;
        this.content = content;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public static Variable getEmpty(){
        return new Variable(Type.VOID, "");
    }

    @Override
    public int compareTo(Variable v) {
        if (!this.getType().equals(v.getType()))
            throw new InvalidArgumentTypeException("Compared variables are not the same type");
        if (this.getValue().equals(v.getValue()))
            return 0;
        if (this.getType().equals(Type.INTEGER)) {
            return Integer.compare(Integer.valueOf(this.getValue()), Integer.valueOf(v.getValue()));
        } else {
            return -1;
//            throw new InvalidArgumentTypeException("Cannot compare given variables: "
//                    + this.getType() + " " + this.getValue() + ", "
//                    + v.getType() + " " + v.getValue());
        }
    }
}
