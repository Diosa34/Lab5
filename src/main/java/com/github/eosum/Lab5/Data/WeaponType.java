package com.github.eosum.Lab5.Data;

/**
 * WeaponType enum
 */
public enum WeaponType {
    HAMMER,
    SHOTGUN,
    KNIFE,
    BAT;

    public static void outputWeaponType() {
        int cnt = 0;
        for (WeaponType element: WeaponType.values()) {
            System.out.println(element + " - " + cnt);
            cnt++;
        }
    }

    public static WeaponType stringValue(String input) {
        return WeaponType.values()[Integer.parseInt(input)];
    }

}
