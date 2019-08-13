package ru.job4j.collections.list;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test.
 */
public class SimpleArrayListTest {
    /**
     * Testing addition ang getting.
     */
    @Test
    public void whenAddThreeThenFirstIndex149() {
        SimpleArrayList<Integer> sl = new SimpleArrayList<>();
        sl.add(13);
        sl.add(149);
        sl.add(48);
        Assert.assertThat(sl.get(1), Is.is(149));
    }
    /**
     * Testing iterator hasnext() and next() dependency, next() accordance, hasnext() - false, exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenHasNext2TimesThenFirstNext() {
        SimpleArrayList<Integer> sl = new SimpleArrayList<>();
        sl.add(13);
        sl.add(149);
        sl.add(48);
        Iterator it  = sl.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(13));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(149));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(48));
        Assert.assertThat(it.hasNext(), Is.is(false));
        it.next();
    }

    /**
     * Testing capacity extending.
     */
    @Test
    public void whenCapa2AndAdd3ThenSize3() {
        SimpleArrayList<Integer> sl = new SimpleArrayList<>(2);
        sl.add(13);
        sl.add(149);
        sl.add(48);
        sl.add(248);
        Assert.assertThat(sl.size(), Is.is(3));
    }
    /**
     * Testing concurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhileIterThenGetCMException() {
        SimpleArrayList<Integer> sl = new SimpleArrayList<>();
        sl.add(13);
        sl.add(149);
        sl.add(48);
        sl.add(248);
        Iterator it = sl.iterator();
        while (it.hasNext()) {
            it.next();
            sl.add(888);
        }
    }
}
