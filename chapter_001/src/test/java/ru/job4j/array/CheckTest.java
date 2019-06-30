package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class CheckTest {
    /**
     * Testing mono odd.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Testing not mono odd.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Testing not mono, even and first element is different .
     */
    @Test
    public void whenDataNotMonoByFirstTrueAndEvenThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Testing not mono, even and last element is different.
     */
    @Test
    public void whenDataNotMonoByLastTrueAndEvenThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Testing one element array.
     */
    @Test
    public void whenOneElementThenAlwaysTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
