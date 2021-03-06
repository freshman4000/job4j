package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 */
public class PointTest {
    /**
     * Testing distance between two points 2d.
     */
    @Test
    public void whenZeroZeroAndZeroTenThenTen() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
    }
    /**
     * Testing distance between two points 3d.
     */
    @Test
    public void whenZeroZeroZeroAndTenZeroZeroThenTen() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(10, 0, 0);
        double result = first.distance(second);
        first.info3d();
        second.info3d();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
    }
    @Test
    public void whenCheckItself() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }
    @Test
    public void whenCheckItself3d() {
        Point point = new Point(0, 0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }
    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
    }
    @Test
    public void whenShow3dInfo() {
        Point first = new Point(1, 1, 1);
        first.info3d();
        Point second = new Point(2, 2, 2);
        second.info3d();
    }
}
