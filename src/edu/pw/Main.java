package edu.pw;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1){
            System.out.println("No path to script was given");
        }

        if (args.length > 1){
            if (args[0].equals("-tree")){
                try {
                    InterpreterInitializer.generateTreeView(args[1]);
                } catch (IOException e) {
                    System.out.println("No such file: " + args[1]);
                }
            } else {
                System.out.println("Unknown flag: " + args[0]);
            }
        } else {
            try {
                InterpreterInitializer.execute(args[0]);
            } catch (IOException e) {
                System.out.println("No such file: " + args[0]);
            }
        }


    }
}
