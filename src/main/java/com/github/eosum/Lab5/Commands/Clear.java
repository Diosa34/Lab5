package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;

/**
 * Clear class
 */
public class Clear implements Command {

    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Clear existing collection
     *
     * @param args arguments for command
     * @param fromFile from where the command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        collectionManager.clear();
    }

    @Override
    public String toString() {
        return "clear - отчистить коллекцию";
    }
}
