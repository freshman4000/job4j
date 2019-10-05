package ru.job4j.srp.srpcalculator.validators;

import ru.job4j.srp.srpcalculator.interfaces.Validation;

public class ValidationExecutor<T> {
    private Validation<T> validation;
    private T input;

    public ValidationExecutor(Validation<T> validation, T input) {
        this.validation = validation;
        this.input = input;
    }

    public boolean executeVal() {
        return validation.validate(input);
    }
}
