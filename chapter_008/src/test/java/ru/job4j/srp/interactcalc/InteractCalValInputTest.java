package ru.job4j.srp.interactcalc;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class InteractCalValInputTest {

    private InteractCalcValInput icv = new InteractCalcValInput();

    /**
     * Testing validation of wrong action number.
     */
    @Test
    public void ifSizeXAndActionGreaterThenFalse() {
       Assert.assertThat(icv.valAction(new InteractCalcUI(), "10000"), Is.is(false));
    }

    /**
     * Testing validation of correct action number.
     */
    @Test
    public void ifSizeXAndActionInRangeThenTrue() {
        Assert.assertThat(icv.valAction(new InteractCalcUI(), "0"), Is.is(true));
    }
    /**
     * Testing validation of wrong value - multiple whitespaces.
     */
    @Test
    public void if2WhiteSpacesThenFalse() {
        Assert.assertThat(icv.valValues("4  4"), Is.is(false));
    }
    /**
     * Testing validation of wrong value - not a number.
     */
    @Test
    public void ifNotANumberThenFalse() {
        Assert.assertThat(icv.valValues("4 f"), Is.is(false));
    }
    /**
     * Testing validation of wrong value - floating point not a dot.
     */
    @Test
    public void ifNotADotThenFalse() {
        Assert.assertThat(icv.valValues("4 4,0"), Is.is(false));
    }
    /**
     * Testing validation of correct value.
     */
    @Test
    public void ifSingWSDotAndNumbersThenTrue() {
        Assert.assertThat(icv.valValues("4 4.0 2 23456789"), Is.is(true));
    }
    /**
     * Testing validation wrong method name.
     */
    @Test
    public void ifXXXThenFalse() {
        Assert.assertThat(icv.valMethodName("XXX"), Is.is(false));
    }
    /**
     * Testing validation correct method name.
     */
    @Test
    public void ifClearThenTrue() {
        Assert.assertThat(icv.valMethodName("clear"), Is.is(true));
    }
}
