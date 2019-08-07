package ru.job4j.collections.tree;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class MyTreeTest {
    /**
     * Testing addition.
     */
    @Test
    public void when6ElFindLastThen6() {
        MyTree<Integer> tree = new MyTree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * Testing search for Not-existing elements.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * Testing iteration, hasFalse() and NSE exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void when6ElIterateTillLast() {
        MyTree<Integer> tree = new MyTree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator it = tree.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(1));
        Assert.assertThat(it.next(), Is.is(2));
        Assert.assertThat(it.next(), Is.is(3));
        Assert.assertThat(it.next(), Is.is(4));
        Assert.assertThat(it.next(), Is.is(5));
        Assert.assertThat(it.next(), Is.is(6));
        Assert.assertThat(it.hasNext(), Is.is(false));
        it.next();
    }

    /**
     * Testing CM exception.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhileIterateThenConcMExc() {
        MyTree<Integer> tree = new MyTree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator it = tree.iterator();
        Assert.assertThat(it.hasNext(), Is.is(true));
        Assert.assertThat(it.next(), Is.is(1));
        Assert.assertThat(it.next(), Is.is(2));
        Assert.assertThat(tree.add(7, 2), is(false));
        tree.add(6, 34);
        it.next();
    }

    /**
     * Testing Binary tree detection.
     */
    @Test
    public void whenLeavesSizeMoreThenTwoThenFalseIfNotThenTrue() {
        MyTree<Integer> tree = new MyTree<Integer>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(4, 5);
        tree.add(5, 6);
        Assert.assertThat(tree.isBinary(tree.getRoot()), Is.is(true));
        tree.add(1, 4);
        Assert.assertThat(tree.isBinary(tree.getRoot()), Is.is(false));
    }
}
