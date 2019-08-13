package ru.job4j.collections.list;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.Assert;

/**
 * Test.
 */
public class SimpleStackTest {
    /**
     * Testing push() and poll().
     */
    @Test
    public void whenAddThreeThenGetByIndex() {
        SimpleStack<Integer> lst = new SimpleStack<>();
        lst.push(88);
        lst.push(234);
        lst.push(2);
        Assert.assertThat(lst.poll(), Is.is(2));
        Assert.assertThat(lst.poll(), Is.is(234));
        Assert.assertThat(lst.poll(), Is.is(88));
        Assert.assertThat(lst.poll(), IsNull.nullValue(null));
    }

}

