package ru.job4j.srp.interactcalc;

import ru.job4j.srp.Calculator;

import java.util.Arrays;

/**
 * This class sets up all mathematical functions that are needed by user at this point and "clear" method, that
 * clears the previous result. By the way, be free to add any other methods to this class.
 */
public class InteractCalc implements Calculator {
    /**
     * This variable defines if previous result exists.
     */
    private boolean curResOn = false;
    /**
     * Value of previous result.
     */
    private double currentResult = 0;

    /**
     * This method adds consecutively all arguments? including previous result (if exists).
     *
     * @param args arguments passed to method by user.
     * @return result of addition.
     */
    @Override
    public double add(double[] args) {
        double result = curResOn ? currentResult + Arrays.stream(args).sum() : Arrays.stream(args).sum();
        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * This method subtracts all arguments from previous result (if it exists)? if not - subtracts all arguments from
     * the first passed argument.
     *
     * @param args arguments passed by user.
     * @return result of subtraction.
     */
    @Override
    public double subtract(double[] args) {
        double result;
        if (curResOn) {
            result = currentResult;
            for (int i = 0; i < args.length; i++) {
                result -= args[i];
            }
        } else {
            result = args[0];
            for (int i = 1; i < args.length; i++) {
                result -= args[i];
            }
        }
        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * This method multiplies the previous result(if exists) in order by every argument, in not - just multiplies
     * arguments by each other.
     *
     * @param args numeric values passed by user.
     * @return result of multiplication.
     */
    @Override
    public double multiply(double[] args) {
        double result = curResOn ? currentResult * Arrays.stream(args).reduce(1, (x, y) -> x * y)
                : Arrays.stream(args).reduce(1, (x, y) -> x * y);
        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * This method first checks if we use previous result. If not - it divides all arguments passed to this method
     * one by another. If - yes - does the same, but then it divides previous result by the result of above mentioned division.
     * In case that previous result is in use and any of arguments equal zero or previous result is not in use
     * and one of the arguments starting with the second one equals zero - this method will throw IllegalArgumentException
     * because division by zero is prohibited.
     *
     * @param args arguments as numbers - passed by user.
     * @return result of division.
     */
    @Override
    public double divide(double[] args) throws IllegalArgumentException {

        double result;
        if (curResOn) {
            if (Arrays.stream(args).anyMatch(x -> x == 0)) {
                throw new IllegalArgumentException();
            }
            result = currentResult;
            for (int i = 0; i < args.length; i++) {
                result /= args[i];
            }
        } else {
            if (Arrays.stream(args).skip(1).anyMatch(x -> x == 0)) {
                throw new IllegalArgumentException();
            }
            result = args[0];
            for (int i = 1; i < args.length; i++) {
                result /= args[i];
            }
        }
        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * THis method sets the usage of current result into false mode.
     */
    @Override
    public void clear() {
        curResOn = false;
    }

    /**
     * This method powers all number by specified power. If current result exists - only one argument should be
     * passed. If it doesn't - two arguments should be passed: first - number to power, and the second - is
     * actual power.
     *
     * @param args arguments passed by user.
     * @return result of powering.
     */
    @Override
    public double power(double[] args) throws IllegalArgumentException {
        double result;
        if (curResOn) {
            if (args.length > 1) {
                throw new IllegalArgumentException();
            }
            result = Math.pow(currentResult, args[0]);

        } else {
            if (args.length > 2) {
                throw new IllegalArgumentException();
            }
            result = Math.pow(args[0], args[1]);
        }
        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * This method calculates sine of an angle.
     * One argument should be passed: value of an angle.
     *
     * @param args arguments passed by user.
     * @return result of calculation.
     */
    @Override
    public double sine(double[] args) throws IllegalArgumentException {
        double result;
        if (args.length > 1) {
            throw new IllegalArgumentException();
        }
        result = Math.sin(args[0]);

        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * This method calculates cosine of an angle.
     * One argument should be passed: value of an angle.
     *
     * @param args arguments passed by user.
     * @return result of calculation.
     */
    @Override
    public double cosine(double[] args) throws IllegalArgumentException {
        double result;
        if (args.length > 1) {
            throw new IllegalArgumentException();
        }
        result = Math.cos(args[0]);

        curResOn = true;
        currentResult = result;
        return currentResult;
    }

    /**
     * This method calculates log with base 10 of a number.
     * One argument should be passed.
     *
     * @param args arguments passed by user.
     * @return result of calculation.
     */
    @Override
    public double log10(double[] args) throws IllegalArgumentException {
        double result;
        if (args.length > 1) {
            throw new IllegalArgumentException();
        }
        result = Math.log10(args[0]);
        curResOn = true;
        currentResult = result;
        return currentResult;
    }
}
