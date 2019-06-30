package ru.job4j.array;

/**
 * Class that creates multiplication table in form of 2D array.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class Matrix {
    /**
     * Method multiple creates 2D array of given size consisted of values that are
     * products of index of subarray and index of element in this subarray.
     * @param size of multiplication table.
     * @return 2D array.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            table[i][j] = (i + 1) * (j + 1);
            }
        }
        return  table;
    }
}
