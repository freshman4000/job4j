package ru.job4j.io;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Testing.
 */
public class SearchTest {
    @Test
    public void whenDepth3ThenAllFilesWithExtInList() {
        Search search = new Search();
        List<File> result = search.files(System.getProperty("java.io.tmpdir"), Arrays.asList("csv", "txt"));
        File path = new File(System.getProperty("java.io.tmpdir"));
        List<File> expected = new LinkedList<>(Arrays.asList(
                new File(path + "/CSVfile.csv"),
                new File(path + "/TXTfile.txt"),
                new File(path + "/depth1/CSVfile1.csv"),
                new File(path + "/depth1/TXTfile1.txt"),
                new File(path + "/depth11/CSVfile11.csv"),
                new File(path + "/depth11/TXTfile11.txt"),
                new File(path + "/depth11/depth21/CSVfile21.csv"),
                new File(path + "/depth11/depth21/TXTfile21.txt")));
        Collections.sort(result);
        Collections.sort(expected);
        Assert.assertThat(result, Is.is(expected));
    }
}
