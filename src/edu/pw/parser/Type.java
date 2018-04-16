package edu.pw.parser;

public enum Type {
    INTEGER("Integer"), TEXT("Text"), IMAGE("Image"), VOID("Void"), BOOLEAN("Boolean");

    private String name;

    Type(String name) {
        this.name = name;
    }
}
