package ru.job4j.srp.interactcalc;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.lang.reflect.Field;

/**
 * Test.
 */
public class InteractCalcTest {
    public InteractCalc ic = new InteractCalc();

    /**
     * Addition testing.
     */
    @Test
    public void if2Plus2Then4() {
        Assert.assertThat(ic.add(new double[]{2, 2}), Is.is(4.0));
    }

//    /**
//     * Subtraction testing.
//     */
//    @Test
//    public void if2Minus2Then0() {
//        Assert.assertThat(ic.subtract(new double[]{2, 2}), Is.is(0.0));
//    }
//
//    /**
//     * Multiplication testing.
//     */
//    @Test
//    public void if2Multiply2Then4() {
//        Assert.assertThat(ic.multiply(new double[]{2, 2}), Is.is(4.0));
//    }
//
//    /**
//     * Division testing.
//     */
//    @Test
//    public void if2Divide2Then1() {
//        Assert.assertThat(ic.divide(new double[]{2, 2}), Is.is(1.0));
//    }
//
//    /**
//     * Testing division by zero when previous answer exists.
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void if2Divide0ThenExceptionPrevAnsOn() {
//        ic.add(new double[]{1, 1});
//        ic.divide(new double[]{0, 2});
//    }
//
//    /**
//     * Testing division by zero when previous answer is cleared.
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void if2Divide0ThenExceptionPrevAnsOff() {
//        ic.divide(new double[]{2, 0});
//    }
//
//    /**
//     * Testing previous answer existence.
//     */
//    @Test
//    public void whenOperationHappenedThenCurAnsTrue() {
//        ic.add(new double[]{1, 1});
//        try {
//            Field field = InteractCalc.class.getDeclaredField("curResOn");
//            field.setAccessible(true);
//            boolean v = (boolean) field.get(ic);
//            Assert.assertThat(v, Is.is(true));
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Testing clear method.
//     */
//    @Test
//    public void whenClearThenCurAnsFalse() {
//        ic.add(new double[]{1, 1});
//        ic.clear();
//        try {
//            Field field = InteractCalc.class.getDeclaredField("curResOn");
//            field.setAccessible(true);
//            boolean v = (boolean) field.get(ic);
//            Assert.assertThat(v, Is.is(false));
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Sin testing.
//     */
//    @Test
//    public void ifSine0Then0() {
//        Assert.assertThat(ic.sine(new double[]{0}), Is.is(0.0));
//    }
//
//    /**
//     * Sin testing - wrong number of arguments.
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void ifArgsNum2ThenException() {
//        ic.sine(new double[]{0, 2});
//    }
//
//    /**
//     * Cosine testing.
//     */
//    @Test
//    public void ifCosine0Then1() {
//        Assert.assertThat(ic.cosine(new double[]{0}), Is.is(1.0));
//    }
//
//    /**
//     * Cosine testing - wrong number of arguments.
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void ifCArgsNum2ThenException() {
//        ic.cosine(new double[]{0, 2});
//    }
//
//    /**
//     * Log10 testing.
//     */
//    @Test
//    public void ifLog10By100Then2() {
//        Assert.assertThat(ic.log10(new double[]{100}), Is.is(2.0));
//    }
//
//    /**
//     * Power testing curResOn == true.
//     */
//    @Test
//    public void ifPowerBy2Then4() {
//        ic.add(new double[]{1, 1});
//        Assert.assertThat(ic.power(new double[]{2}), Is.is(4.0));
//    }
//
//    /**
//     * Power testing curResOn == false.
//     */
//    @Test
//    public void if2PowerBy2Then4() {
//        Assert.assertThat(ic.power(new double[]{2, 2}), Is.is(4.0));
//    }
//
//    /**
//     * Power testing - wrong number of arguments, curRes - ON.
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void ifLogArgsNum3ThenException() {
//        ic.power(new double[]{0, 2, 3});
//    }
//
//    /**
//     * Power testing - wrong number of arguments, curRes - OFF.
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void ifLogArgsNum2ThenException() {
//        ic.add(new double[]{1, 1});
//        ic.power(new double[]{0, 2});
//    }
}
