package ru.job4j.tracker;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.Assert;

/**
 * Test.
 */
public class TrackerSingletonTest {
    public void comparison(Object a, Object b) {
        Assert.assertThat(true, Is.is(a.equals(b)));
    }
    /**
     * Testing TrackerSingleEager.
     */
    @Test
    public void whenDiffNamesThenEagerInstancesAreEqual() {
        TrackerSingleEager t1 = TrackerSingleEager.getInstance();
        TrackerSingleEager t2 = TrackerSingleEager.getInstance();
        comparison(t1, t2);
    }
    /**
     * Testing TrackerSingleLazy.
     */
    @Test
    public void whenDiffNamesThenLazyInstancesAreEqual() {
        TrackerSingleLazy t3 = TrackerSingleLazy.getInstance();
        TrackerSingleLazy t4 = TrackerSingleLazy.getInstance();
        comparison(t3, t4);
    }
    /**
     * Testing TrackerSingleEnum.
     */
    @Test
    public void whenDiffNamesThenEnumInstancesAreEqual() {
        TrackerSingleEnum t5 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum t6 = TrackerSingleEnum.INSTANCE;
        comparison(t5, t6);
    }
    /**
     * Testing TrackerSingleInnerClass.
     */
    @Test
    public void whenDiffNamesThenInnerInstancesAreEqual() {
        TrackerSingleInnerClass t7 = TrackerSingleInnerClass.getInstance();
        TrackerSingleInnerClass t8 = TrackerSingleInnerClass.getInstance();
        comparison(t7, t8);
    }
}