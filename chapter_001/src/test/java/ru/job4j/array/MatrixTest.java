package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class MatrixTest {
/**
 * Testing size three.
 */
    @Test
    public void when2on2() {
    Matrix matrix = new Matrix();
    int[][] table = matrix.multiple(2);
    int[][] expect = {
            {1, 2},
            {2, 4}
    };
    assertThat(table, is(expect));
}

    /**
     * Testing size 0.
     */
    @Test
    public void when0thenEmpty() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(0);
        int[][] expected = {};
        assertThat(table, is(expected));
    }
}
