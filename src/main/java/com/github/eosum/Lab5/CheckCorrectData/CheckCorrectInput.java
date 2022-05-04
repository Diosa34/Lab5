package com.github.eosum.Lab5.CheckCorrectData;

import com.github.eosum.Lab5.Data.Coordinates;
import com.github.eosum.Lab5.Data.WeaponType;

/**
 * CheckCorrectInput class
 */
public class CheckCorrectInput {

    /**
     * @param x coordinate x
     * @return is x correct
     */
    public int checkCoordinateX(Float x) {
        if (x == null) return 0;
        if (Coordinates.checkValidX(x)) return 1;
        return 0;
    }

    /**
     *
     * @param y y coordinate
     * @return is y correct
     */
    public int checkCoordinateY(Float y) {
        if (y == null) return 0;
        if (Coordinates.checkValidY(y)) return 1;
        return 0;
    }

    /**
     *
     * @param name element name
     * @return is name correct
     */
    public int checkName(String name) {
        if (name == null) return 0;
        if (!name.equals("0") && !name.equals("")) return 1;
        return 0;
    }

    /**
     *
     * @param realHero real hero field
     * @return is field correct
     */
    public int checkRealHero(Boolean realHero) {
        if (realHero != null) return 1;
        return 0;
    }

    public int checkRealHeroFile(String realHero) {
        if (realHero.equals(true) || realHero.equals(false)) return 1;
        return 0;
    }

    public int checkHasToothpick(String hasToothpick) {
        if(hasToothpick.equals(true) || hasToothpick.equals(false)) return 1;
        return 0;
    }
    /**
     *
     * @param soundtrackName soundtrack name
     * @return is soundtrack name correct
     */
    public int checkSoundtrackName(String soundtrackName) {
        if (soundtrackName != null) return 1;
        return 0;
    }

    /**
     *
     * @param weaponType weapon type
     * @return is weapon type correct
     */
    public int checkWeaponType(String weaponType) {
        try {
            int value = Integer.parseInt(weaponType);
            if (value >= 0 && value < WeaponType.values().length) return 1;

            return 0;
        }
        catch (IllegalArgumentException e) {
            return 0;
        }
    }

    public int checkWeaponTypeFile(String weaponType) {
        try {
            WeaponType.valueOf(weaponType);
            return 1;
        }
        catch (IllegalArgumentException e) {
            return 0;
        }
    }

    /**
     *
     * @param car the brand of car
     * @return is field correct
     */
    public int checkCar(String car) {
        if (car != null) return 1;
        return 0;
    }

}
