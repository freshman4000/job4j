package ru.job4j.loop;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.Assert;

/**
 * Test.
 */
public class FitnessTest {
/**
 * Testing.
 */
@Test
public void if50And100Then2() {
    Fitness fit = new Fitness();
    int result = fit.calc(50, 100);
    int expected = 2;
    Assert.assertThat(result, Is.is(expected));
}
}
