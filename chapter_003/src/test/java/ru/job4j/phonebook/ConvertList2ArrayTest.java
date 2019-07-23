package ru.job4j.phonebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class ConvertList2ArrayTest {
    /**
     * Testing not null array.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Testing list of arrays -> list conversion.
     */
    @Test
    public void when3ArraysThenOneList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> incoming = List.of(new int[]{1, 2}, new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert(incoming);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expected));
    }
}