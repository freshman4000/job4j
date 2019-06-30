package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 */
public class BubbleSortTest {
    /**
     * Testing sorting with bubble sort method more then one element.
     */
    @Test
    public void when7351Then1357() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.bsort(new int[] {7, 3, 5, 1});
        int[] expected = {1, 3, 5, 7};
        assertThat(result, is(expected));
    }
    /**
     * Testing sorting with bubble sort method more then one element.
     */
    @Test
    public void when1Then1() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.bsort(new int[] {1});
        int[] expected = {1};
        assertThat(result, is(expected));
    }
    /**
     * Testing empty array.
     */
    @Test
    public void whenEmptyThenEmpty() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.bsort(new int[]{});
        int[] expected = {};
        assertThat(result, is(expected));
    }
}
