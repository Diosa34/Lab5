package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;

/**
 * PrintAscending class
 */
public class PrintAscending implements Command {
    private final CollectionManager collectionManager;

    public PrintAscending(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     *
     * @param args arguments
     * @param fromFile from where this command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        collectionManager.printAscending();
    }

    @Override
    public String toString() {
        return "print_ascending - выводит элементы в порядке возрастания";
    }

}
