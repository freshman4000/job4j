package ru.job4j.collections.set;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test.
 */
public class SimpleSetTest {
    /**
     * Testing addition, null value addition, no duplicates and iteration.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenDupsAddedThenNoDupsInSet() {
        SimpleSet<Integer> ss = new SimpleSet<>(10);
        ss.add(3);
        ss.add(4);
        ss.add(null);
        ss.add(3);
        ss.add(4);
        ss.add(8);
        Iterator it = ss.iterator();
        Assert.assertThat(it.next(), Is.is(3));
        Assert.assertThat(it.next(), Is.is(4));
        Assert.assertThat(it.next(), Is.is(8));
        Assert.assertThat(it.hasNext(), Is.is(false));
        it.next();
    }
}
