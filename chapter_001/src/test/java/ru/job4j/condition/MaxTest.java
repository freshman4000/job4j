package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 */
public class MaxTest {
    /**
     * Testing.
     */
    @Test
    public void whenLeft10Right5Then10() {
        Max max = new Max();
        int result = max.max(10, 5);
        assertThat(result, is(10));
    }
    /**
     * Testing.
     */
    @Test
    public void whenLeft10Right10Then10() {
        Max max = new Max();
        int result = max.max(10, 10);
        assertThat(result, is(10));
    }
    /**
     * Testing.
     */
    @Test
    public void whenLeft5Right10Then10() {
        Max max = new Max();
        int result = max.max(5, 10);
        assertThat(result, is(10));
    }
}
