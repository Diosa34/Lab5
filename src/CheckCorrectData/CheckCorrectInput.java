package CheckCorrectData;

import Data.Coordinates;
import Data.WeaponType;

/**
 * CheckCorrectInput class
 */
public class CheckCorrectInput {
    /**
     * @param x coordinate x
     * @return is x correct
     */
    public int checkCoordinateX(Float x) {
        if (Coordinates.checkValidX(x)) return 1;
        return 0;
    }

    /**
     *
     * @param y y coordinate
     * @return is y correct
     */
    public int checkCoordinateY(Float y) {
        if (Coordinates.checkValidY(y)) return 1;
        return 0;
    }

    /**
     *
     * @param name element name
     * @return is name correct
     */
    public int checkName(String name) {
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
