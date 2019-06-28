package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 */
public class SqAreaTest {
/**
 * Testing calculation of square of rectangle
 */
    @Test
    public void whenP20K4Then16() {
        SqArea sqArea = new SqArea();
        assertThat(sqArea.square(20, 4), is(16));
    }
    /**
     * Testing calculation of square of rectangle
     */
    @Test
    public void whenP48K7Then63() {
        SqArea sqArea = new SqArea();
        assertThat(sqArea.square(48, 7), is(63));
    }
}
