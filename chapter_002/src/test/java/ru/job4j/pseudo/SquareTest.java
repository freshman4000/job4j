package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class SquareTest {
    /**
     * Testing square.
     */
    @Test
    public void whenSqThenSq() {
        Square square = new Square();
        String result = square.draw();
        Assert.assertThat(result, Is.is(new StringBuilder()
                .append("++++").append(System.lineSeparator())
                .append("+  +").append(System.lineSeparator())
                .append("+  +").append(System.lineSeparator())
                .append("++++").toString()));
    }
}
