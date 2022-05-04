package com.github.eosum.Lab5.App;

import com.github.eosum.Lab5.Exceptions.PermissionFileException;
import com.github.eosum.Lab5.Exceptions.ProcessingFileException;
import com.github.eosum.Lab5.Parser.ParserFromXml;

import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Main class
 */
public class Main {
    /**
     * Program entry point
     *
     * @param args the input arguments
     */
    public static void main(String args[]) throws ProcessingFileException, PermissionFileException {

        CollectionManager collectionManager = new CollectionManager();
        CommandsList commandsList = new CommandsList(collectionManager);
        try {
            ParserFromXml parserFromXml = new ParserFromXml();
            parserFromXml.parser(args);
            collectionManager.mergeCollections(parserFromXml.getCollection(), parserFromXml.getLastIdFromFile());
        }
        catch (ProcessingFileException | PermissionFileException e) {
            System.out.println("\n");
            return;
        }

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
