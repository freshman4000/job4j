package ru.job4j.phonebook;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class ConvertMatrix2ListTest {
    /**
     * Matrix conversion testing.
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    /**
     * Non-Matrix conversion testing.
     */
    @Test
    public void when2on3ArrayThenList5() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4, 9}
        };
        List<Integer> expect = List.of(
                1, 2, 3, 4, 9
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}