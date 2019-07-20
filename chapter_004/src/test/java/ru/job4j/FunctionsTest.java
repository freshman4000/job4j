package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import org.hamcrest.number.IsCloseTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Test.
 */
public class FunctionsTest implements Functions {
    @Override
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> results = new ArrayList<>();
        for (int index = start; index != end; index++) {
            results.add(func.apply((double) index));
        }
        return results;
    }

    /**
     * Testing linear.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functions function = new FunctionsTest();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertThat(result, Is.is(expected));
    }

    /**
     * Testing quadro.
     */
    @Test
    public void whenQuadroFunctionThenQuadroResults() {
        Functions function = new FunctionsTest();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 1 * x + 5);
        List<Double> expected = Arrays.asList(60D, 83D, 110D);
        Assert.assertThat(result, Is.is(expected));
    }

    /**
     * Testing logo.
     */
    @Test
    public void whenLogFunctionThenLogResults() {
        Functions function = new FunctionsTest();
        List<Double> result = function.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(1.6, 1.79, 1.95);
        for (int i = 0; i != 3; i++) {
            Assert.assertThat(result.get(i), IsCloseTo.closeTo(expected.get(i), 0.01));
        }

    }
}

