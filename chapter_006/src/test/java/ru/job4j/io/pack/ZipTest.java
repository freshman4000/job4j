package ru.job4j.io.pack;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {
    @Test
    public void whenZippedThenEqualUnzipped() {
        List<File> result = new LinkedList<>();
        List<File> expected = new LinkedList<>(Arrays.asList(
                new File("src/main/resources/tmp/LOGfile.log"),
                new File("src/main/resources/tmp/TXTfile.txt"),
                new File("src/main/resources/tmp/depth1/LOGfile1.log"),
                new File("src/main/resources/tmp/depth1/TXTfile1.txt"),
                new File("src/main/resources/tmp/depth11/LOGfile11.log"),
                new File("src/main/resources/tmp/depth11/TXTfile11.txt"),
                new File("src/main/resources/tmp/depth11/depth21/LOGfile21.log"),
                new File("src/main/resources/tmp/depth11/depth21/TXTfile21.txt")
        ));
        String[] args = {
                "-d",
                "src/main/resources/tmp",
                "-e",
                "*.csv",
                "-o",
                "src/main/resources/tmp.zip"
        };
        Zip zip = new Zip();
        zip.pack(zip.seekBy(args[1], args[3]),
                new File(args[5]));
        File file = new File("./src/main/resources/tmp.zip");
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry zipEntry;
            while (true) {
                zipEntry = zis.getNextEntry();
                if (zipEntry == null) {
                    break;
                }
                result.add(new File(zipEntry.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        result.forEach(x -> System.out.println(x));
//        expected.forEach(x -> System.out.println(x));
        Assert.assertThat(expected, Is.is(result));
    }
}
