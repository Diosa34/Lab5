package Commands;

import App.CollectionManager;
import InputInfo.ElementInput;

/**
 * Command Add class
 */
public class Add implements Command {
    private final CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Add an element to collection
     *
     * @param args arguments for command
     * @param fromFile from where the command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {

        ElementInput elementInput = new ElementInput();
        collectionManager.add(elementInput.resultElement(collectionManager.getId()));

    }

    @Override
    public String toString() {
        return "add - добавляет новый элемент в коллекцию";
    }
}
