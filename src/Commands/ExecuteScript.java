package Commands;

import App.CommandsList;
import CheckCorrectData.CheckPathCorrect;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;


/**
 * ExecuteScript class
 */
public class ExecuteScript implements Command{
    private final CommandsList commandsList;
    private final CheckPathCorrect checkPathCorrect = new CheckPathCorrect();
    private HashSet<Path> existingPathList = new HashSet<>();


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
                return;
            }
            else {
                path = Paths.get(args[0].trim());
                Path base = Paths.get("");
                absolutePath = base.resolve(path).toAbsolutePath();
            }


            if (existingPathList.contains(absolutePath)) {
                System.out.println("Вызов скриптов зациклен");
                return;
            }

            existingPathList.add(absolutePath);

            Scanner inputFromFile = new Scanner(absolutePath);
            while (inputFromFile.hasNext()){
                String command = inputFromFile.nextLine();
                commandsList.execute(command, true);
            }

            existingPathList.clear();

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
