package ru.job4j.seabattle.players;

import java.util.List;

/**
 * This interface represents abstract player, that has two main methods:
 * setShips() and makeChoice(). Others - are utility methods.
 */
public interface Player {
    /**
     * Makes players move.
     */
    void makeChoice();

    /**
     * Initialises specific players metaData.
     */
    void init();

    /**
     * Sets name.
     */
    void setName();

    /**
     * Sets all ships, described in rules to players battleground
     * in interactive manner.
     */
    void setShips();

    /**
     * Figures out players enemies, and sets their list.
     */
    void setEnemies();

    /**
     * Sets status of the player.
     *
     * @param inGame true or false.
     */
    void setStatus(boolean inGame);

    /**
     * Status getter.
     *
     * @return true or false.
     */
    boolean getStatus();

    /**
     * Gets battleField boards assigned to player.
     *
     * @return List of boards, represented by 2d array.
     */
    List<int[][]> getBattlefields();

    /**
     * Gets name of the player.
     *
     * @return players name in String format.
     */
    String getName();
}