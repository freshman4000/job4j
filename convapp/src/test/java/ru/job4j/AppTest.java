package ru.job4j;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.apache.commons.io.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test for App.
 */
public class AppTest {
    /**
     * Right answer Test :-)
     */
    @Test
    public void shouldBe2UsersWhenEmailBelongTo2UniqueUsers() {
        Path source = Paths.get("src/test/resources/userList.txt");
        Path outPut = Paths.get("src/test/resources/result.txt");
        App.main(new String[]{source.toString(), outPut.toString()});
        File result = outPut.toFile();
        File expected = Paths.get("src/test/resources/Expected.txt").toFile();
        try {
            assertTrue(FileUtils.contentEquals(result, expected));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
