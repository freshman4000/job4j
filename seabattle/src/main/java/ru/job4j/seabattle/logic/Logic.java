package ru.job4j.seabattle.logic;

/**
 * This interface is responsible for all kinds of logic used
 * in the game.
 *
 * @param <T> interface return type parameter.
 */
public interface Logic<T> {
    T executeLogic();
}
