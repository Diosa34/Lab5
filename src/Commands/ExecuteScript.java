package Commands;

import App.CollectionManager;
import App.CommandsList;
import CheckCorrectData.CheckExistPath;
import CheckCorrectData.CheckPathCorrect;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * ExecuteScript class
 */
public class ExecuteScript implements Command{
    private final CommandsList commandsList;
    private final CheckPathCorrect checkPathCorrect = new CheckPathCorrect();
    private final CheckExistPath checkExistPath = new CheckExistPath();


    public ExecuteScript(CommandsList commandsList) {
        this.commandsList = commandsList;
    }

    /**
     * Execute given script
     *
     * @param args args contains path to script file if the command was called from file
     * @param fromFile from where this command was called
     */
    @Override
    public void execute(String args[], boolean fromFile) {
        try {
            Path path;
            Path absolutePath;
            if (!checkPathCorrect.checkPath(args)) {
                commandsList.stopExecute();
                return;
            }
            else {
                path = Paths.get(args[0].trim());
                Path base = Paths.get("");
                absolutePath = base.resolve(path).toAbsolutePath();
            }

            if (!fromFile) {
                checkExistPath.clearList();
            }

            if (checkExistPath.checkExistPath(absolutePath)) {
                System.out.println("Вызов скриптов зациклен");

                commandsList.stopExecute();
            }

            Scanner inputFromFile = new Scanner(absolutePath);
            while (inputFromFile.hasNext()){
                String command = inputFromFile.nextLine();
                commandsList.execute(command, true);
            }

        }
        catch (NullPointerException e) {
            //System.out.println("");
        }
        catch (IOException e) {
            System.out.println("Нет доступа к файлу.");
        }
    }


    @Override
    public String toString() {
        return "execute_script - выполняет ваш скрипт";
    }
}
