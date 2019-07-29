package ru.job4j.collections.list;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class SimpleQueueTest {
    /**
     * Testing pushing and polling on two stacks.
     */
    @Test
    public void whenPush123ThenPoll123() {
        SimpleQueue<Integer> sq = new SimpleQueue<>();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        Assert.assertThat(sq.poll(), Is.is(1));
        Assert.assertThat(sq.poll(), Is.is(2));
        Assert.assertThat(sq.poll(), Is.is(3));
        Assert.assertThat(sq.poll(), IsNull.nullValue());
    }
}
