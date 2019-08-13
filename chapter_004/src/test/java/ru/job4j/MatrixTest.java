package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;

/**
 * Test.
 */
public class MatrixTest {
    /**
     * Testing 2d array of Integers transformation to List of Integers.
     */
    @Test
    public void when2DArrIntThenListOfIntegers() {
        Matrix mat = new Matrix();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                mat.matrix[i][j] = (i * 10 + j);
            }
        }
        Assert.assertThat(mat.transform(mat.matrix),
                Is.is(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                        10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                        20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                        30, 31, 32, 33, 34, 35, 36, 37, 38, 39
                )));
    }
}
