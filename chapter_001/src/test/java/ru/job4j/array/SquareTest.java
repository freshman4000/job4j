package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class SquareTest {
    /**
     * Testing three numbers.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
    /**
     * Testing seven numbers.
     */
    @Test
    public void whenBound7Then14916253649() {
        int bound = 7;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expected = new int[] {1, 4, 9, 16, 25, 36, 49};
        assertThat(result, is(expected));
    }
    /**
     * Testing zero numbers.
     */
    @Test
    public void whenBound0Then0() {
        int bound = 0;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expected = new int[0];
        assertThat(result, is(expected));
    }
}