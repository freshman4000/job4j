package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 */
public class BoardTest {
    /**
     * Testing 3 columns and 3 rows.
     */
    @Test
    public void when3And3Then3Rows3Columns() {
        Board board = new Board();
        String line = System.lineSeparator();
        String expect = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(board.paint(3, 3), is(expect));
    }

    /**
     * Testing 5 columns and 4 rows.
     */
    @Test
    public void when5And4Then4Rows5Columns() {
        Board board = new Board();
        String line = System.lineSeparator();
        String expect = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(board.paint(5, 4), is(expect));
    }
}
