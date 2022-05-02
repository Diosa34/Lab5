package App;

import Parser.ParserFromXml;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.exit;


/**
 * Main class
 */
public class Main {
    /**
     * Program entry point
     *
     * @param args the input arguments
     */
    public static void main(String args[]) {

        CollectionManager collectionManager = new CollectionManager();
        CommandsList commandsList = new CommandsList(collectionManager);

        ParserFromXml parserFromXml = new ParserFromXml();
        parserFromXml.parser(args);
        collectionManager.mergeCollections(parserFromXml.getCollection(), parserFromXml.getLastIdFromFile());

        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.print("Введите команду: ");
                String command = input.nextLine();
                commandsList.execute(command, false);
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("Завершение работы.");
        }





    }
}
