package com.github.eosum.Lab5.Data;

/**
 * Car class
 */
public class Car {
    private String name; // поле не может быть null

    public Car (String car) {
        this.name = car;
    }

    @Override
    public String toString() {
        return name;
    }
}
