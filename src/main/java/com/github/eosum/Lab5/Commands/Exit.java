package com.github.eosum.Lab5.Commands;

/**
 * Exit class
 */
public class Exit implements Command {

    /**
     * Exit the program
     *
     * @param args arguments
     * @param fromFile from where this command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        System.exit(0);
    }

    @Override
    public String toString() {
        return "exit - завершение программы";
    }
}
