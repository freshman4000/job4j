package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 */
public class MultiMaxTest {
    /**
     * Testing method max last.
     */
    @Test
    public void when123then3() {
        MultiMax multiMax = new MultiMax();
        assertThat(multiMax.max(1, 2, 3), is(3));
    }
    /**
     * Testing method max middle.
     */
    @Test
    public void when132then3() {
        MultiMax multiMax = new MultiMax();
        assertThat(multiMax.max(1, 3, 2), is(3));
    }
    /**
     * Testing method max first.
     */
    @Test
    public void when321then3() {
        MultiMax multiMax = new MultiMax();
        assertThat(multiMax.max(3, 2, 1), is(3));
    }
}
