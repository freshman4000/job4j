package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 */
public class PaintTest {
    /**
     * Testing 6 rows
     */
    @Test
    public void whenPyramid6Height() {
    Paint paint = new Paint();
    String ln = System.lineSeparator();
    String expected = new StringJoiner(ln, "", ln)
                                    .add("     ^     ")
                                    .add("    ^^^    ")
                                    .add("   ^^^^^   ")
                                    .add("  ^^^^^^^  ")
                                    .add(" ^^^^^^^^^ ")
                                    .add("^^^^^^^^^^^").toString();
    String result = paint.pyramid(6);
    assertThat(result, is(expected));
    }
}
