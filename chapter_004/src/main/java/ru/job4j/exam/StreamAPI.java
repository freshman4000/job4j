package ru.job4j.exam;

import java.util.Arrays;

/**
 * Class which filters array to even numbers, maps each element to power of 2, and sums all elements.
 */
public class StreamAPI {
    /**
     * Stream realisation.
     *
     * @param array given array.
     * @return sum of stream elements.
     */
    static int func(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).map(y -> y * y).sum();
    }
}
