package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;
/**
 * Test.
 */
public class TriangleTest {
    /**
     * Testing half-perimeter.
     */
    @Test
    public void whenOneTwoThreeThenThree() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(2, 0));
        assertThat(triangle.period(), closeTo(2.61, 0.1));
    }
    /**
     * Testing area of triangle.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(3, 3));
        assertThat(triangle.area(), closeTo(4.5, 0.1));
    }
}
