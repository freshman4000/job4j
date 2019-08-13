package ru.job4j.collections.list;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.Assert;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test.
 */
public class DynamicLinkedListTest {
    /**
     * Testing add() and get().
     */
    @Test
    public void whenAddThreeThenGetByIndex() {
        DynamicLinkedList<Integer> lst = new DynamicLinkedList<>();
        lst.add(88);
        lst.add(234);
        lst.add(2);
        Assert.assertThat(lst.get(0), Is.is(2));
        Assert.assertThat(lst.get(2), Is.is(88));
    }

    /**
     * Testing iterator hasnext() and next() dependency, next() accordance, hasnext() - false, exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenHasNext2TimesThenFirstNext() {
        DynamicLinkedList<Integer> sl = new DynamicLinkedList<>();
        sl.add(13);
        sl.add(149);
        sl.add(48);
        Iterator it = sl.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(48));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(149));
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(13));
        Assert.assertThat(it.hasNext(), Is.is(false));
        it.next();
    }

    /**
     * Testing concurrentModificationException.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhileIterThenGetCMException() {
        DynamicLinkedList<Integer> sl = new DynamicLinkedList<>();
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
