package ru.job4j.seabattle.validators;

/**
 * This interface is responsible for all validations in the game.
 *
 * @param <T> validation return type parameter.
 */
public interface Validator<T> {
    T validate();
}
