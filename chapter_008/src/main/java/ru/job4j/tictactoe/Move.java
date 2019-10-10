package ru.job4j.tictactoe;

import ru.job4j.tictactoe.players.Player;

import java.util.Map;

/**
 * This is controller class used to guide and control player actions.
 */
public class Move {
    private String[][] dots;
    private Map<Integer, int[]> freeCells;

    public Move(String[][] dots, Map<Integer, int[]> freeCells) {
        this.dots = dots;
        this.freeCells = freeCells;
    }

    /**
     * This method checks if player choice of cell is in range and
     * saves X or O (depends on player) in array of String player values.
     * @param player current player.
     */
    public void execute(Player player) {
        int choice = -1;
        while (choice < 0 || choice >= freeCells.size()) {
            choice = player.makeChoice();
        }
        int i = freeCells.get(choice)[0];
        int j = freeCells.get(choice)[1];
        dots[i][j] = player.getSign();
    }
}