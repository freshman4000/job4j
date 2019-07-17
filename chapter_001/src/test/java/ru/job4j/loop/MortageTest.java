package ru.job4j.loop;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.Assert;
/**
 * Test.
 */
public class MortageTest {
    /**
     * Testing.
     */
    @Test
    public void whenAm100Mon10Per50Then2() {
        Mortage mortage = new Mortage();
        int result = mortage.year(100, 10, 50);
        int expected = 2;
        Assert.assertThat(result, Is.is(expected));
    }
}
