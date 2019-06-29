package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 */
public class FactorialTest {
    /**
     * Testing 0.
     */
    @Test
    public void when0then1() {
        Factorial fact = new Factorial();
       assertThat(fact.calc(0), is(1));
    }
    /**
     * Testing 0.
     */
    @Test
    public void when5then120() {
        Factorial fact = new Factorial();
        assertThat(fact.calc(5), is(120));
    }
}
