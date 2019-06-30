package ru.job4j.array;

/**
 * Class MatrixCheck that checks if boolean values of each diagonal are the same.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class MatrixCheck {
    /**
     * Method mono checks if boolean values in both diagonals are the same.
     * @param data 2D array of boolean values.
     * @return boolean value.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int lastIndex = data.length - 1;
        for (int i = 0, j = 0; i < data.length - 1; i++, j++) {
                if (data[i][j] != data[i + 1][j + 1]) {
                    return false;
                }
                if (data[i][lastIndex] != data[i + 1][lastIndex - 1]) {
                    return false;
                }
                lastIndex--;
            }
        return result;
    }
}