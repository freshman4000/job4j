package ru.job4j.array;

/**
 * Class FindLoop founds index by value of the given element.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class FindLoop {
    /**
     * Method indexOf finds index of array element with given value.
     * @param data given array.
     * @param el given value.
     * @return index of array element.
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }
}
