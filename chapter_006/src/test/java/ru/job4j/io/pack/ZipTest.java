package ru.job4j.io.pack;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {
    @Test
    public void whenZippedThenEqualUnzipped() {
        List<String> result = new ArrayList<>();
        List<String> expected = Arrays.asList(
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\LOGfile.log",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\TXTfile.txt",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\depth1\\LOGfile1.log",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\depth1\\TXTfile1.txt",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\depth11\\LOGfile11.log",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\depth11\\TXTfile11.txt",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\depth11\\depth21\\LOGfile21.log",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp\\depth11\\depth21\\TXTfile21.txt"
        );
        String[] args = {
                "-d",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp",
                "-e",
                "*.csv",
                "-o",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp.zip"
        };
        Zip zip = new Zip();
        zip.pack(zip.seekBy(args[1], args[3]),
                new File(args[5]));
        File file = new File("C:\\projects\\job4j\\chapter_006\\src\\main\\resources\\tmp.zip");
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry zipEntry;
            while (true) {
                zipEntry = zis.getNextEntry();
                if (zipEntry == null) {
                    break;
                }
                result.add(zipEntry.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertThat(expected, Is.is(result));
    }
}
