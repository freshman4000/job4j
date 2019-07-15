package ru.job4j.phonebook;

import java.util.List;

/**
 * Class that converst lis to 2d array with given row number.
 */
public class ConvertList2Array {
    /**
     * List to 2d array conversion.
     *
     * @param list given list.
     * @param rows given row number.
     * @return 2d array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int cRow = 0;
        int cCell = 0;
        for (Integer integer : list) {
            array[cRow][cCell++] = integer;
            if (cCell > cells - 1) {
                cRow++;
                cCell = cCell % cells;
            }
        }
        return array;
    }
}