package ru.job4j.condition;

/**
 * class Max calculates the biggest number.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 28.06.2019.
 * @version 1.0.
 */
public class Max {
    /**
     * Method returns the biggest number out of two values
     * @param left first value type int
     * @param right second value type int
     * @return biggest value
     */
    public int max(int left, int right) {
        return left > right ? left : right;
    }
    public int max(int left, int right, int up) {
        return max(left, right) > up ? max(left, right) : right;
    }
    public int max(int left, int right, int up, int down) {
        return max(left, right, up) > down ? max(left, right, up) : down;
    }
}