package ru.job4j.lsp;

/**
 * Interface for validation purpose.
 * @param <T> typeParameter.
 */
public interface Validation<T> {
    /**
     * Validation interface method.
     * @param item - object for validation.
     * @return boolean value-result of validation.
     */
    boolean validateByCriteria(T item);
}
