package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;
import com.github.eosum.Lab5.InputInfo.ElementInput;

/**
 * RemoveGreater class
 */
public class RemoveGreater implements Command{
    private final CollectionManager collectionManager;

    public RemoveGreater(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args[], boolean fromFile) {
        ElementInput elementInput = new ElementInput();
        collectionManager.removeGreater(elementInput.resultElement(collectionManager.getId()));
    }

    @Override
    public String toString() {
        return "remove_greater - удаляет все элементы, превышающий заданный";
    }

}
