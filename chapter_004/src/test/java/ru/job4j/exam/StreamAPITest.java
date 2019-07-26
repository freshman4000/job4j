package ru.job4j.exam;

import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class StreamAPITest {
    /**
     * Testing.
     */
    @Test
    public void whenArrayThenEvenPoweredSum() {
        int[] array = {1, 18, 3, 7, 2};
        int result = StreamAPI.func(array);
        Assert.assertThat(result, Is.is(18 * 18 + 2 * 2));
    }
}
