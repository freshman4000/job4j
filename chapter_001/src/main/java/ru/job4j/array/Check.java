package ru.job4j.array;

/**
 * Class Check checks array if it consists from the same boolean value.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class Check {
    /**
     * Method check if array consists of the same boolean values.
     * @param data array of booleans.
     * @return true or false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i != data.length - 1; i++) {
        if (data[i] != data[i + 1]) {
            return false;
            }
        }
        return result;
    }
}
