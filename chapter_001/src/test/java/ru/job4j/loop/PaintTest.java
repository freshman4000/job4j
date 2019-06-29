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
     * Testing right triangle.
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
//        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("^   ")
                                .add("^^  ")
                                .add("^^^ ")
                                .add("^^^^")
                                .toString()
                )
        );
    }
    /**
     * Testing left triangle.
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
//        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }
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
