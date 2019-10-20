package ru.job4j.seabattle.inputs;

/**
 * This interface is responsible for all kinds of inputs used
 * in the game.
 *
 * @param <T> interface return type parameter.
 */
public interface Input<T> {
    T getInput();
}
