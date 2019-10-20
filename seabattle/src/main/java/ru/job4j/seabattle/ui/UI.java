package ru.job4j.seabattle.ui;

/**
 * This interface is responsible for game actions sequence
 * and players actions visualisation.
 * Suggested chronology:
 * - specify number of players (game can be for 2 and more players).
 * - specify player type (AI or Human).
 * - specify players name.
 */
public interface UI {
    void start();
}
