package Data;

/**
 * WeaponType enum
 */
public enum WeaponType {
    HAMMER,
    SHOTGUN,
    KNIFE,
    BAT;

    static WeaponType[] nameWeaponType = WeaponType.values();

    public static void outputWeaponType() {
        for (WeaponType element: nameWeaponType) {
            System.out.print(element + " ");
        }
        System.out.print(": ");
    }

}
