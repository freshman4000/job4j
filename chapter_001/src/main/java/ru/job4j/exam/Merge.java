package ru.job4j.exam;

/**
 * Class Merge merges two arrays
 * @author Vit Efremov
 * @since 01.07.2019.
 * @version 1.1.
 */
public class Merge {
    /**
     * Method creates 3-d party array by merging two ordered arrays of any length each.
     * @param left array.
     * @param right array.
     * @return 3-d party array.
     */
    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < result.length; i++) {
            if (countLeft == left.length) {
                result[i] = right[countRight++];
            }
            if (countRight == right.length) {
                result[i] = left[countLeft++];
            } else {
                result[i] = left[countLeft] < right[countRight] ? left[countLeft++] : right[countRight++];
            }
        }
        return result;
    }
}
