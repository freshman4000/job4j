package ru.job4j.condition;

/**
 * Class SqArea calculates square of rect while
 * given its sides proportion and perimeter.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 28.06.2019.
 * @version 1.0.
 */
public class SqArea {
    /**
     * Method square calculates square of rectangle.
     * @param p perimeter of rectangle type int.
     * @param k proportion of width to height type int.
     * @return square of rectangle.
     */
    public int square(int p, int k) {
        int height = p / ((1 + k) * 2);
        return (height) * (k * height);
    }
}
