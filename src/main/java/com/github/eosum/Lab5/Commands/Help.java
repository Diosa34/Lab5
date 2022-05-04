package com.github.eosum.Lab5.Commands;

import java.util.HashMap;

/**
 * Help class
 */
public class Help implements Command {
    private final HashMap<String, Command> commands;

    public Help(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * Prints references for commands
     *
     * @param args arguments
     * @param fromFile from where this command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        for (Command description: commands.values()) {
            System.out.println(description.toString());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "help - выводит справку по доступным командам";
    }
}
