package Commands;

import App.CollectionManager;
import InputInfo.ElementInput;

/**
 * AddIfMin class
 */
public class AddIfMin implements Command{
    private final CollectionManager collectionManager;

    public AddIfMin(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Add an element if it is smaller than the smallest existing one
     *
     * @param args arguments for command
     * @param fromFile from where the command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        ElementInput elementInput = new ElementInput();
        collectionManager.addIfMin(elementInput.resultElement(collectionManager.getId()));

    }

    @Override
    public String toString() {
        return "add_if_min - добавляет элемент, если он меньше чем наименьший элемент коллекции";
    }

}
