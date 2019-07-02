package ru.job4j.array;

/**
 * Class Square generates array of square of numbers from one to given value included.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class Square {
    /**
     * Method calculate creates and fills array with squares.
     * @param bound upper inclusive bound for numbers to use.
     * @return array of squares type int.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = i * i;
        }
        return result;
    }
}
