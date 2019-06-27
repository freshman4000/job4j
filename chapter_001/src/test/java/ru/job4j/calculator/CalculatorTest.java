package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Vit Efremov
 * @since 28.06.2019
 * @version 1
 */
public class CalculatorTest {
    /**
     * Testing addition
     */
    @Test
    public void whenOnePlusOneThenTwo () {
        Calculator calc = new Calculator();
        double expected = 2D;
        double result = calc.add(1D, 1D);
        assertThat(expected, is(result));
    }
    /**
     * Testing subtraction
     */
    @Test
    public void whenTenMinSevenThenThree () {
        Calculator calc = new Calculator();
        double expected = 3D;
        double result = calc.subtract(10D, 7D);
        assertThat(expected, is(result));
    }
    /**
     * Testing division
     */
    @Test
    public void whenTenDivFiveThenTwo () {
        Calculator calc = new Calculator();
        double expected = 2D;
        double result = calc.div(10D, 5D);
        assertThat(expected, is(result));
    }
    /**
     * Testing multiplication
     */
    @Test
    public void whenThreeMulTwoThenSix () {
        Calculator calc = new Calculator();
        double expected = 6D;
        double result = calc.multiply(3D, 2D);
        assertThat(expected, is(result));
    }
}
