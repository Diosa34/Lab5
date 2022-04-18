package Commands;

import App.CollectionManager;
import Data.WeaponType;

/**
 * CountLessThanWeaponType class
 */
public class CountLessThanWeaponType implements Command{
    private final CollectionManager collectionManager;

    public CountLessThanWeaponType(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Counts the number of element that has smaller weapon type
     *
     * @param args arguments for command
     * @param fromFile from where the command was called
     */
    @Override
    public void execute(String[] args, boolean fromFile) {
        if (args.length == 0) {
            System.out.println("Не введен обязательный аргумент - тип оружия");
            return;
        }

        try {
            WeaponType.valueOf(args[0]);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Такого типа оружия не существует.");
        }
        collectionManager.countLessThanWeaponType(args[0]);
    }

    @Override
    public String toString() {
        return "count_less_than_weapon_type - выводит кол - во элементов, weapon type которых меньше заданного";
    }

}
