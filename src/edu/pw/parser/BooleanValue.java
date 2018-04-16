package edu.pw.parser;

public enum BooleanValue {
    TRUE("true"), FALSE("false");

    private String value;

    public String getValue() {
        return value;
    }

    BooleanValue(String value) {
        this.value = value;
    }
}
