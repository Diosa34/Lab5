package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;

/**
 * Show class
 */
public class Show implements Command {

    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args[], boolean fromFile) {
        collectionManager.show();
    }

    @Override
    public String toString() {
        return "show - выводит все элементы коллекции в строковом представлении";
    }
}
