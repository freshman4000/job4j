package ru.job4j.array;

/**
 * Class Turn reverses array.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 30.06.2019.
 * @version 1.0.
 */
public class Turn {
    /**
     * Method back flips all elements in array.
     * @param array of given values.
     * @return reversed array.
     */
    public int[] back(int[] array) {
        int first = 0;
        int second = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
                int temp = array[first];
                array[first] = array[second];
                array[second] = temp;
                first++;
                second--;
               }
        return array;
    }
}
