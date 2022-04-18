package Data;

/**
 * Coordinates class
 */
public class Coordinates {

    private Float x; // поле не может быть null, max value = 620
    private Float y; // поле не может быть null, max value = 784
    private static Float max_x = Float.valueOf(620);
    private static Float max_y = Float.valueOf(784);

    public Coordinates(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x coordinate X
     * @return x belongs to the allowed segment
     */
    public static boolean checkValidX(Float x) {
        if (x > max_x) return false;
        return true;
    }

    /**
     *
     * @param y coordinate Y
     * @return y belongs to the allowed segment
     */
    public static boolean checkValidY (Float y) {
        if (y > max_y) return false;
        return true;
    }

    /**
     *
     * @return the largest allowed value of x
     */
    public static Float getMaxX() {
        return max_x;
    }

    /**
     *
     * @return the largest allowed value of y
     */
    public static Float getMaxY() {
        return max_y;
    }

    /**
     *
     * @return x
     */
    public Float getX() {
        return x;
    }

    /**
     *
     * @return y
     */
    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }

}
