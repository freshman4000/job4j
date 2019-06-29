package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 */
public class CounterTest {
    /**
     * Testing addition of even numbers
     */
    @Test
    public void when0And10Then30() {
        Counter counter = new Counter();
        assertThat(counter.add(0, 10), is(30));
    }
}
