package ru.job4j.collections;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test.
 */
public class SimpleArrayTest {
    SimpleArray<Integer> sa = new SimpleArray<>(5);

    @Before
    public void setUp() {
        sa.add(23);
        sa.add(3);
        sa.add(623);
        sa.add(213);
        sa.add(6);
    }

    /**
     * Add/Get test.
     */
    @Test
    public void whenAdded5ThenGet2IsThirdAdded() {
        Assert.assertThat(sa.get(2), Is.is(623));
    }

    /**
     * Remove test.
     */
    @Test
    public void whenRemoved1ThenGet1IsThirdAdded() {
        sa.remove(1);
        Assert.assertThat(sa.get(1), Is.is(623));
    }

    /**
     * Set test.
     */
    @Test
    public void whenSetThenSetValueReturns() {
        sa.set(1, 111);
        Assert.assertThat(sa.get(1), Is.is(111));
    }

    /**
     * Testing hasNext() to next() affection, iteration, hasNext() true/false and NSE exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextWhileHasNextFalseThenNSE() {
        Iterator it = sa.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(23));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(3));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(623));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(213));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(6));
        it.next();
    }
}
