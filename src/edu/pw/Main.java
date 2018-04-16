package edu.pw;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            InterpreterInitializer.start(args);
        } catch (IOException e) {
            System.out.println("No such file");
        }

    }
}
