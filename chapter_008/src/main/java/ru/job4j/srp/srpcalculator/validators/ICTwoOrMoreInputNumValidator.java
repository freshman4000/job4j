package ru.job4j.srp.srpcalculator.validators;

import ru.job4j.srp.srpcalculator.interfaces.Validation;

/**
 * This class validates if input has two or more numbers.
 */
public class ICTwoOrMoreInputNumValidator implements Validation<double[]> {

    @Override
    public boolean validate(double[] args) {
        return args.length > 1;
    }
}
