package ru.job4j.tictactoe.input;

/**
 * Interface responsible for all inputs.
 *
 * @param <T> returning type.
 */
public interface Input<T> {
    T getInput();
}
