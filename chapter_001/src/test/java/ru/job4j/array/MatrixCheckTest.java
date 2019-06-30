package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class MatrixCheckTest {
    /**
     * Testing odd true.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Testing odd false.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Testing even true.
     */
    @Test
    public void whenEvenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, false, false},
                {true, false, true, true},
                {false, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Testing even false.
     */
    @Test
    public void whenEvenDataMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true, false},
                {false, true, true, false},
                {true, false, true, true},
                {false, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}