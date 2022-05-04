package com.github.eosum.Lab5.Commands;

import com.github.eosum.Lab5.App.CollectionManager;
import com.github.eosum.Lab5.InputInfo.ElementInput;

/**
 * Update class
 */
public class Update implements Command {
    private final CollectionManager collectionManager;

    public Update(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(String args[], boolean fromFile) {
        try {
            if (args.length == 0) {
                System.out.println("Не введен обязательный аргумент - id");
                return;
            }

            final Long id = Long.parseLong(args[0]);

            if (!this.collectionManager.updateById(id)) {
                System.out.println("Объекта с id = " + id + " не найдено");
                return;
            }

            ElementInput elementInput = new ElementInput();
            collectionManager.add(elementInput.resultElement(id));

        }
        catch (NumberFormatException e) {
            System.out.println("Некорректный ввод! id введен неверно");
        }
    }

    @Override
    public String toString() {
        return "update - обновить значение элемента коллекции, id которого совпадает с исходным";
    }
}
