package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;

/**
 * Info class
 */
public class Info implements Command {

    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Prints the collection info
     *
     * @param args arguments
     * @param fromFile from where this command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        collectionManager.info();
    }

    @Override
    public String toString() {
        return "info - выводит информацию о коллекции (тип, дата инициализации и тд)";
    }
}
