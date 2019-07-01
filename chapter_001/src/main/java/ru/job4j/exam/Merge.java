package ru.job4j.exam;

/**
 * Class Merge merges two arrays
 * @author Vit Efremov
 * @since 01.07.2019.
 * @version 1.0.
 */
public class Merge {
    /**
     * Method creates 3-d party array by merging two ordered arrays of any length each.
     * @param left array.
     * @param right array.
     * @return 3-d party array.
     */
    public int[] merge(int[] left, int[] right) {
        //init 3-d party array
        int[] result = new int[left.length + right.length];
        int countLeft = 0; //create counter for iteration on left array
        int countRight = 0; //create counter for iteration on right array
        for (int i = 0; i < result.length; i++) {
        //checking if all element of left array have been iterated or not
            if (countLeft == left.length) {
                //if left iteration is done - just assigning remained elements from right array
            result[i] = right[countRight++];
        }
            //checking if all elements of right array have been iterated or not
        if (countRight == right.length) {
            //if right iteration is done - just assigning remained elements from left array
            result[i] = left[countLeft++];
            //if both not iterated to the end yet, picking the min current value from both arrays to assign
        } else {
            result[i] = left[countLeft] < right[countRight] ? left[countLeft++] : right[countRight++];
        }
        }
        return result;
    }
}
