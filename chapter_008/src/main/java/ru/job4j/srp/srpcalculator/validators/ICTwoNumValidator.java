package ru.job4j.srp.srpcalculator.validators;

import ru.job4j.srp.srpcalculator.interfaces.Validation;

public class ICTwoNumValidator implements Validation<double[]> {
    @Override
    public boolean validate(double[] item) {
        return item.length == 2;
    }
}
