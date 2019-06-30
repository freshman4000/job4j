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
        int firstInd = 0;
        int secondInd = array.length - 1;
        for (int i = 0; i < array.length; i++) {
                if (firstInd < secondInd) {
                int temp = array[firstInd];
                array[firstInd] = array[secondInd];
                array[secondInd] = temp;
                firstInd++;
                secondInd--;
            } else {
                    break;
                }
        }
        return array;
    }
}
