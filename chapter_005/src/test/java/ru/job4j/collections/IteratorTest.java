package ru.job4j.collections;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.Assert;

/**
 * Test.
 */
public class IteratorTest {
    @Test
    public void whenNext9TimesThen100() {
        int[][] agrArr = {{1, 43, 6, 267},
                          {4, 23, 18},
                          {67, 100, 145}};
        MyIterator it = new MyIterator(agrArr);
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        Assert.assertThat(it.next(), Is.is(100));
        it.next();
        Assert.assertThat(it.hasNext(), Is.is(false));
    }
}
