package ru.job4j.io;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.io.find.FileSearcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Testing.
 */
public class FileSearcherTest {
    /**
     * Testing search by mask.
     */
    @Test
    public void whenByMaskThenByMask() {
        String[] args = new String[]{"-d",
                System.getProperty("user.dir") + "/src/main/resources/tmp",
                "-n",
                "*.txt",
                "-m",
                "-o",
                "/searchResult.txt"};
        Path[] path = FileSearcher.resolvePaths(args[1], args[6]);
        FileSearcher fileVisitor = new FileSearcher(args[3], path[0]);
        try {
            Files.walkFileTree(path[0], fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileSearcher.writeResultToFile(path[1]);
        List<String> result = new ArrayList<>();
        try {
            Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir") + args[6]));
            while (sc.hasNextLine()) {
                result.add(sc.nextLine().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> expected = new ArrayList<>(Arrays.asList(
                "Following files were found during search:",
                System.getProperty("user.dir") + "/src/main/resources/tmp/depth11/depth21/TXTfile21.txt",
                System.getProperty("user.dir") + "/src/main/resources/tmp/depth11/TXTfile11.txt",
                System.getProperty("user.dir") + "/src/main/resources/tmp/TXTfile.txt",
                System.getProperty("user.dir") + "/src/main/resources/tmp/depth1/TXTfile1.txt"));

        Collections.sort(expected);
        Collections.sort(result);
        Assert.assertThat(expected, Is.is(result));
    }
}
