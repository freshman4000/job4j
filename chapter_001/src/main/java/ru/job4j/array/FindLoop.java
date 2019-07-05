package ru.job4j.array;

/**
 * Class FindLoop founds index by value of the given element.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.1.
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

    /**
     * Method indexOf finds index of array element with given value in specified inclusive range.
     * @param data given array.
     * @param el given value.
     * @param start bottom inclusive range.
     * @param finish upper inclusive range.
     * @return index of array element.
     */
    public int indexOf(int[] data, int el, int start, int finish){
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;}
        }
        return rst;
    }

    /**
     * If one tries to find min value by the means of indexOf(4 params) method,
     * then testing takes 13 seconds.
     * @param data - array to sort.
     * @return sorted array.
     */
    public int[] sort(int[] data) {
        int count = 0;
        for (int i = Integer.MIN_VALUE; i != Integer.MAX_VALUE; i++) {
            int index = indexOf(data, i, count, data.length - 1);
            if (index != -1) {
                data[index] = data[count];
                data[count] = i;
                count++;
                if (count == data.length - 1) {
                    break;
                }
            }
        }
        return data;
    }
}
