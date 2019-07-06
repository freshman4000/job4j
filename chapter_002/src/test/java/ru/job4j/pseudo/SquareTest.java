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
                .append("++++\n\r")
                .append("+  +\n\r")
                .append("+  +\n\r")
                .append("++++\n\r").toString()));
    }
}
