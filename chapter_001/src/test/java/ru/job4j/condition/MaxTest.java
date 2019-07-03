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
    public void whenLeft10Right5Up3Then10() {
        Max max = new Max();
        int result = max.max(10, 5, 3);
        assertThat(result, is(10));
    }
    /**
     * Testing.
     */
    @Test
    public void whenLeft10Right5Up3Down100Then100() {
        Max max = new Max();
        int result = max.max(10, 5, 3, 100);
        assertThat(result, is(100));
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
    public void whenLeft10Right10Up10Then10() {
        Max max = new Max();
        int result = max.max(10, 10, 10);
        assertThat(result, is(10));
    }
    /**
     * Testing.
     */
    @Test
    public void whenLeft10Right10Up10Down10Then10() {
        Max max = new Max();
        int result = max.max(10, 10, 10, 10);
        assertThat(result, is(10));
    }
}
