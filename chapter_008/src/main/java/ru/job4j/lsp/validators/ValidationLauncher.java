package ru.job4j.lsp.validators;

public class ValidationLauncher<T> {
    private Validation<T> validator;

    public ValidationLauncher(Validation<T> validator) {
        this.validator = validator;
    }
    public boolean launchValidation(T item) {
       return validator.validateByCriteria(item);
    }
}
