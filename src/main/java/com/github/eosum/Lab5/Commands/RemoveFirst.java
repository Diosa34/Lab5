package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;

/**
 * RemoveFirst class
 */
public class RemoveFirst implements Command {
    private final CollectionManager collectionManager;

    public RemoveFirst(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args[], boolean fromFile) {
        collectionManager.removeFirst();
    }

    @Override
    public String toString() {
        return "remove_first - удаляет первый элемент в коллекции";
    }
}
