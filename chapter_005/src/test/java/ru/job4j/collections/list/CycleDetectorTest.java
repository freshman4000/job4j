package ru.job4j.collections.list;

import ru.job4j.collections.list.DynamicLinkedList.Node;
import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class CycleDetectorTest {
    /**
     * Testing cyclic.
     */
    @Test
    public void whenCycleThenTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);
        Assert.assertThat(CycleDetector.hasCycle(first), Is.is(true));
    }

    /**
     * Testing not cyclic.
     */
    @Test
    public void whenCycleThenFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        Assert.assertThat(CycleDetector.hasCycle(first), Is.is(false));
    }
}
