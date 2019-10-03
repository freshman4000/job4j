package ru.job4j.srp.srpcalculator;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.srp.srpcalculator.calculators.ICalculator;
import ru.job4j.srp.srpcalculator.inputs.TestInput;
import ru.job4j.srp.srpcalculator.launchers.ICUILauncher;
import ru.job4j.srp.srpcalculator.logics.ICLogic;
import ru.job4j.srp.srpcalculator.logs.State;
import ru.job4j.srp.srpcalculator.messageprinters.ICMessagePrinter;
import ru.job4j.srp.srpcalculator.processors.ICNumbersInputProcessor;
import ru.job4j.srp.srpcalculator.userinterfaces.InterCalcUI;
import ru.job4j.srp.srpcalculator.validators.ICCommandInputValidator;
import ru.job4j.srp.srpcalculator.validators.ICNumInputValidator;
import ru.job4j.srp.srpcalculator.validators.ICTwoOrMoreInputNumValidator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Testing class for srpCalculator.
 */
public class SrpCalculatorTest {
    private PrintStream standardOut = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void setBefore() {
        System.setOut(new PrintStream(out));
    }


    public void setAfter() {
        System.setOut(standardOut);
    }

    /**
     * Testing addition.
     */
    @Test
    public void whenTwoPlusTwoThenFour() {
        setBefore();
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"1", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        Assert.assertThat(out.toString().substring(157, 160), Is.is("4.0"));
        setAfter();
    }

    /**
     * Testing subtraction.
     */
    @Test
    public void whenTwoMinusTwoThenZero() {
        setBefore();
        State.setReuseOn(false);
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"2", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        Assert.assertThat(out.toString().substring(157, 160), Is.is("0.0"));
        setAfter();
    }

    /**
     * Testing multiplication.
     */
    @Test
    public void whenTwoTimesTwoThenFour() {
        setBefore();
        State.setReuseOn(false);
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"3", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        Assert.assertThat(out.toString().substring(157, 160), Is.is("4.0"));
        setAfter();
    }

    /**
     * Testing Division.
     */
    @Test
    public void whenTwoDIvTwoThenOne() {
        setBefore();
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"4", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        Assert.assertThat(out.toString().substring(157, 160), Is.is("1.0"));
        setAfter();
    }

    /**
     * Testing natural previous answer change.
     */
    @Test
    public void whenNoActionsThenFalse() {
        boolean result = State.isReuseOn();
        Assert.assertThat(result, Is.is(false));
    }

    /**
     * Testing natural previous answer change.
     */
    @Test
    public void whenThereAreActionsThenTrue() {
        setBefore();
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"4", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        boolean result = State.isReuseOn();
        Assert.assertThat(result, Is.is(true));
        setAfter();
    }

    /**
     * Testing clearance method.
     */
    @Test
    public void whenClearThenFalse() {
        setBefore();
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"4", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        boolean result = State.isReuseOn();
        Assert.assertThat(result, Is.is(true));
        new ICUILauncher().launch(
                new InterCalcUI(),
                new ICLogic(new ICNumbersInputProcessor(new TestInput(new String[]{"2 2"})), new ICMessagePrinter(), new ICalculator()),
                new TestInput(new String[]{"0", "forcedExit"}),
                new ICMessagePrinter(),
                new ICNumInputValidator(),
                new ICCommandInputValidator()
        );
        result = State.isReuseOn();
        Assert.assertThat(result, Is.is(false));
        setAfter();
    }

    /**
     * Testing two number validator.
     */
    @Test
    public void whenTwoNumThenTrue() {
        Assert.assertThat(new ICTwoOrMoreInputNumValidator().validate(new double[]{0.1, 3.0}), Is.is(true));
    }

    /**
     * Testing two number validator.
     */
    @Test
    public void whenOneNumThenFalse() {
        Assert.assertThat(new ICTwoOrMoreInputNumValidator().validate(new double[]{0.1}), Is.is(false));
    }

    /**
     * Testing number input string validator.
     */
    @Test
    public void whenDoubleWhiteSpaceThenFalse() {
        Assert.assertThat(new ICNumInputValidator().validate("2.0  2.0"), Is.is(false));
    }

    /**
     * Testing number input string validator.
     */
    @Test
    public void whenNotDotSSeparatorThenFalse() {
        Assert.assertThat(new ICNumInputValidator().validate("2,0 2.0"), Is.is(false));
    }

    /**
     * Testing number input string validator.
     */
    @Test
    public void whenNotNumberThenFalse() {
        Assert.assertThat(new ICNumInputValidator().validate("w 2.0"), Is.is(false));
    }

    /**
     * Testing number input string validator.
     */
    @Test
    public void whenAllOkThenTrue() {
        Assert.assertThat(new ICNumInputValidator().validate("2 2.0 1111111"), Is.is(true));
    }

    /**
     * Testing command input string validator.
     */
    @Test
    public void whenInRangeThenTrue() {
        Assert.assertThat(new ICCommandInputValidator().validate("2"), Is.is(true));
    }

    /**
     * Testing command input string validator.
     */
    @Test
    public void whenNotInRangeThenFalse() {
        Assert.assertThat(new ICCommandInputValidator().validate("20000"), Is.is(false));
    }

    /**
     * Testing processor.
     */
    @Test
    public void whenCurResOnAndOneNumberThenTwoNumArray() {
        State.setReuseOn(true);
        State.setCurrentValue(111.0);
        TestInput input = new TestInput(new String[]{"20"});
        Assert.assertThat(new ICNumbersInputProcessor(input).process(), Is.is(new double[]{111.0, 20.0}));
    }

    /**
     * Testing processor.
     */
    @Test
    public void whenCurResOffAndOneNumberThenOneNumArray() {
        State.setReuseOn(false);
        State.setCurrentValue(111.0);
        TestInput input = new TestInput(new String[]{"20"});
        Assert.assertThat(new ICNumbersInputProcessor(input).process(), Is.is(new double[]{20.0}));
    }
}
