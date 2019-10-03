package ru.job4j.srp.srpcalculator.validators;

import ru.job4j.srp.srpcalculator.interfaces.Validation;

/**
 * This class validates if input consists of numbers separated by single whitespaces.
 * If numbers are fractional, validates if they use "dot" as  floating point separator.
 */
public class ICNumInputValidator implements Validation<String> {

    @Override
    public boolean validate(String input) {
        return input.matches("(([\\d]+)(\\.)?([\\d]+)? )*?(([\\d]+)(\\.)?([\\d]+)?)$");
    }
}
