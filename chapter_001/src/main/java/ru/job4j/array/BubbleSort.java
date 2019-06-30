package ru.job4j.array;

/**
 * Class Bubblesort sorts array by using so called bubblesort method.
 * * @author Vit Efremov (freshman4000@gmail.com).
 *  * @since 30.06.2019.
 *  * @version 1.0.
 */
public class BubbleSort {
    public int[] bsort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array [i] > array [j]) {
                    int temp = array[j];
                    array[j] = array [i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
