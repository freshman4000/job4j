package ru.job4j.array;

import java.util.Arrays;
/**
 * Class ArrayDuplicate receives array as incoming value and
 * returns new array of values with no duplicates.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class ArrayDuplicate {
    /**
     * Method remove removes all duplicates from array.
     * @param array - given array of String objects.
     * @return copy of array with no duplicates in it.
     */
    public String[] remove(String[] array) {
        int count = array.length;
        for (int i = 0; i != array.length; i++) {
            for (int j = i + 1; j != array.length; j++) {
                if (array[i] != null && array[i].equals(array[j])) {
                    array[j] = null;
                    count--;
                }
                if (array[i] == null && array[j] != null) {
                    array[i] = array[j];
                    array[j] = null;
                }
            }
        }
        array = Arrays.copyOf(array, count);
    return array;
    }
}
