package Commands;

import App.*;

/**
 * RemoveById class
 */
public class RemoveById implements Command {

    private final CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args[], boolean fromFile) {
        try {
            if (args.length == 0) {
                System.out.println("Не введен обязательный аргумент - id");
                return;
            }

            final Long id = Long.parseLong(args[0]);
            if (!this.collectionManager.removeById(id)) {
                System.out.println("Объекта с id = " + id + " не найдено");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Некорректный ввод! id не введен или введен неверно");
        }
    }

    @Override
    public String toString() {
        return "remove_by_id - удаляет элемент из коллекции по его id";
    }
}
