package com.github.eosum.Lab5.App;

import com.github.eosum.Lab5.Data.HumanBeing;
import com.github.eosum.Lab5.Parser.ParserToXml;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * CollectionManager Class
 *
 * managing a collection of items
 */
public class CollectionManager {
    LinkedList<HumanBeing> collection = new LinkedList<>();
    private Long id = 1L;
    ZonedDateTime initTime = ZonedDateTime.now();

    /**
     *
     * @return the smallest allowed id
     */
    public Long getId() {
        return id++;
    }

    /**
     * Merge collection from file and this one
     *
     * @param collectionFromFile collection was given from file
     * @param id the last id from file
     */
    public void mergeCollections(LinkedList<HumanBeing> collectionFromFile, Long id) {
        collection.addAll(collectionFromFile);
        this.id = id;
    }

    /**
     * Save collection to XML
     */
    public void save() {
        HashSet<Long> idList = new HashSet<>();

        for(HumanBeing element: collection) {
            if (element.getHasToothpick() == null) idList.add(element.getId());
            if (element.getImpactSpeed() == null) idList.add(element.getId());
            if (element.getWeaponType() == null) idList.add(element.getId());
            if (element.getMinutesOfWaiting() == null) idList.add(element.getId());
        }

        if (idList.isEmpty()) {
            ParserToXml parserToXml = new ParserToXml();
            parserToXml.parseToXml(collection);
        }
        else {
            System.out.println("Невозможно сохранить коллекцию, т.к. у элементов с id из списка есть поля = null");
            System.out.println(idList);
            idList.clear();
        }
    }

    /**
     * Print an information about collection
     */
    public void info() {
        System.out.println("Тип - " + collection.getClass() + "\n"
                            + "Количество элементов - " + collection.size() + "\n"
                            + "Дата инициализации - " + initTime);
    }

    /**
     * Remove elements that greater than given one
     *
     * @param CompareElement the element to compare with
     */
    public void removeGreater(HumanBeing CompareElement) {
        for (HumanBeing element: collection) {
            if (element.compareTo(CompareElement) == 1) {
                collection.remove(element);
            }
        }
    }

    /**
     * Add an element to collection if it is smaller than the smallest existing one
     *
     * @param Element element is needed to add
     */
    public void addIfMin(HumanBeing Element) {
        Collections.sort(collection);
        if (collection.peekFirst().compareTo(Element) >= 0) collection.addFirst(Element);
    }

    /**
     * Find elements with given substring and print them
     *
     * @param SubString substring to be found
     */
    public void filterStartsWithSoundtrackName(String SubString) {
        for (HumanBeing element: collection) {
            String NameSoundtrack = element.getSoundtrackName();
            if (NameSoundtrack.startsWith(SubString)) {
                System.out.println(element);
            }
        }
    }

    /**
     * Count the number of elements with smaller value of weapon type
     *
     * @param weaponType the value to be compared with
     */
    public void countLessThanWeaponType(String weaponType) {
        int amount = 0;
        for(HumanBeing element: collection) {
            if (element.getWeaponType().length() < weaponType.length()) {
                amount++;
            }
        }
        System.out.println(amount);
    }

    /**
     * Print the collection in ascending order
     */
    public void printAscending() {
        Collections.sort(collection);
        for (HumanBeing element: collection) {
            System.out.println(element + "\n");
        }
    }

    /**
     * Remove the first element in collection
     */
    public void removeFirst() {
        collection.removeFirst();
    }

    /**
     * Print the collection
     */
    public void show() {
        for (HumanBeing element: collection) {
           System.out.println(element + "\n");
        }
    }

    /**
     * Clear the collection
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Add an element to collection
     *
     * @param element element that is needed to add
     */
    public void add(HumanBeing element) {
        collection.add(element);
    }

    /**
     * Updating element's data
     *
     * @param updateId id to update the item by
     * @return is updating successful
     */
    public boolean updateById(Long updateId) {
        for(HumanBeing element: collection) {
            if (element.getId() == updateId) {
                collection.remove(element);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param deleteId id to delete the item by
     * @return is deleting successful
     */
    public boolean removeById(Long deleteId) {
        for(HumanBeing element: collection) {
            if (element.getId() == deleteId) {
                collection.remove(element);
                return true;
            }
        }
        return false;
    }

}

