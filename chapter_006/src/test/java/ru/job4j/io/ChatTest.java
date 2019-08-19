package ru.job4j.io;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.io.*;

/**
 * Test.
 */
public class ChatTest {
    @Test
    public void chatTest() {
        final String LN = System.lineSeparator();
        PrintStream outDef = System.out;
        InputStream inDef = System.in;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream inputStream = new ByteArrayInputStream(
                    ("Hello" + LN + "stop" + LN + "continue" + LN + "end").getBytes())
        ) {
            System.setOut(new PrintStream(out));
            System.setIn(inputStream);
            new Chat("src/test/java/ru/job4j/io/test.txt").start();

            Assert.assertThat(out.toString(), Is.is("In God we trust!" + LN + "In God we trust!" + LN));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setIn(inDef);
        System.setOut(outDef);
    }
}
