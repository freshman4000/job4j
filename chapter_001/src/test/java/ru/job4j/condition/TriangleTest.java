package ru.job4j.condition;

import org.hamcrest.core.Is;
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
        Triangle triangle = new Triangle();
        assertThat(triangle.period(1.0, 2.0, 3.0), Is.is(3.0));
    }
    /**
     * Testing area of triangle.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle();
        assertThat(triangle.area(0, 0, 3, 0, 3, 3), closeTo(4.5, 0.1));
    }
}
