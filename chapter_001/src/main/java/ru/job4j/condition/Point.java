package ru.job4j.condition;

/**
 * class Point calculates distance between two points.
 * @author Vit Efremov.
 * @since 28.06.2019.
 * @version 1.0.
 */
public class Point {
    /**
     *
     * @param x1 coordinate x1 type int.
     * @param y1 coordinate y1 type int.
     * @param x2 coordinate x2 type int.
     * @param y2 coordinate y2 type int.
     * @return distance between (x2,y2) and (x1,y1).
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}