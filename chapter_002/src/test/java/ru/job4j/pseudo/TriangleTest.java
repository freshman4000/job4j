package ru.job4j.pseudo;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class TriangleTest {
    /**
     * Testing triangle.
     */
    @Test
    public void whenTrThenTr() {
        Triangle triangle = new Triangle();
        String result = triangle.draw();
        Assert.assertThat(result, Is.is(new StringBuilder().append("   +").append(System.lineSeparator())
                                                           .append("  + +").append(System.lineSeparator())
                                                           .append(" +   +").append(System.lineSeparator())
                                                           .append("+++++++").toString()));
    }
}
