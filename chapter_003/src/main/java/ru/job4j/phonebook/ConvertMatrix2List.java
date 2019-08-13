package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts 2d array to list.
 */
public class ConvertMatrix2List {
    /**
     * 2d array to the list conversion.
     * @param array given 2d array.
     * @return list with all elements from 2d array;
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}