package App;

import Commands.*;

import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.exit;

/**
 * CommandsList class
 */
public class CommandsList {
    public final HashMap<String, Command> commands = new HashMap<>();

    /**
     * initializing the list of commands
     *
     * @param collectionManager the collection manager
     */
    public CommandsList(CollectionManager collectionManager) {
        commands.put("add", new Add(collectionManager));
        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("update", new Update(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("remove_first", new RemoveFirst(collectionManager));
        commands.put("print_ascending", new PrintAscending(collectionManager));
        commands.put("filter_starts_with_soundtrack_name", new FilterStartsWithSoundtrackName(collectionManager));
        commands.put("count_less_than_weapon_type", new CountLessThanWeaponType(collectionManager));
        commands.put("remove_greater", new RemoveGreater(collectionManager));
        commands.put("add_if_min", new AddIfMin(collectionManager));
        commands.put("execute_script", new ExecuteScript(this));
        commands.put("save", new Save(collectionManager));
        commands.put("help", new Help(commands));
        commands.put("exit", new Exit());
    }

    /**
     * Parsing commands and arguments
     *
     * @param command input command
     * @param fromFile from where command was inputted
     */
    public void execute(String command, boolean fromFile) {

        String commandCut[] = command.trim().split("\\s+");
        String commandName = commandCut[0];
        String args[] = Arrays.copyOfRange(commandCut, 1, commandCut.length);

        if (commands.containsKey(commandName)) {
            commands.get(commandName).execute(args, fromFile);
        } else {
            if (fromFile) {
                System.out.println("Некорректная команда " + commandName);
                return;
            }
            System.out.println("Команда не найдена. Повторите ввод.");
        }
    }

    public void stopExecute() {
        return;
    }
}
