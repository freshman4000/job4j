package ru.job4j.exam;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 */
public class MergeTest {
    /**
     * Testing.
     */
    @Test
    public void when14913and235678101112Then12345678910111213() {
        Merge merge = new Merge();
        int[] result = merge.merge(new int[] {1, 4, 9, 13}, new int[] {2, 3, 5, 6, 7, 8, 10, 11, 12});
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertThat(result, is(expected));
    }
}
