package Commands;

import App.*;

/**
 * FilterStartsWithSoundtrackName class
 */
public class FilterStartsWithSoundtrackName implements Command{
    private final CollectionManager collectionManager;

    public FilterStartsWithSoundtrackName(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     *
     * @param args contains the substring to find
     * @param fromFile from where this command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        String SubString = String.join(" ", args);
        collectionManager.filterStartsWithSoundtrackName(SubString);
    }

    @Override
    public String toString() {
        return "filter_starts_with_soundtrack_name - выводит элементы, имя песни которых начинается с заданной подстроки";
    }

}
