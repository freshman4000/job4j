package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class TurnTest {
    /**
     * Testing even amount of elements.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    /**
     * Testing odd amount of elements.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2, 3, 4, 5});
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
