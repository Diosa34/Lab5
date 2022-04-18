package Commands;

import App.CollectionManager;

/**
 * Save class
 */
public class Save implements Command {

    private final CollectionManager collectionManager;

    public Save(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args, boolean fromFile) {
        collectionManager.save();
    }

    @Override
    public String toString() {
        return "save - сохраняет коллекцию в файл";
    }
}
