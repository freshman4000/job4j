package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 */
public class ConverterTest {
    /**
     * Testing Rub to Eur
     */
    @Test
    public void whenSevenHunRubThenTenEuro() {
        Converter con = new Converter();
        int expect = 10;
        int result = con.rubleToEuro(700);
        assertThat(result, is(expect));
    }
    /**
     * Testing Rub to Usd
     */
    @Test
    public void whenSixHunRubThenTenUsd() {
        Converter con = new Converter();
        int expect = 10;
        int result = con.rubleToUsd(600);
        assertThat(result, is(expect));
    }
    /**
     * Testing Rub to Eur
     */
    @Test
    public void whenTenEuroThenSevenHunRub() {
        Converter con = new Converter();
        int expect = 700;
        int result = con.euroToRub(10);
        assertThat(result, is(expect));
    }
    /**
     * Testing Rub to Usd
     */
    @Test
    public void whenTenUsdThenSixHunRub() {
        Converter con = new Converter();
        int expect = 600;
        int result = con.usdToRub(10);
        assertThat(expect, is(result));
    }
}
