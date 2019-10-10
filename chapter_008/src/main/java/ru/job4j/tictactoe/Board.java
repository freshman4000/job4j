package ru.job4j.tictactoe;

import ru.job4j.tictactoe.utilities.Drawing;

import java.util.Arrays;

/**
 * This class represents board, where game is taking place.
 */
public class Board implements Drawing {

    private int size;
    private String placeHolder;
    private String[][] dots;

    public Board(int size, String placeHolder) {
        this.size = size;
        this.placeHolder = placeHolder;
        dots = new String[size][size];
        init();
    }

    public String[][] getDots() {
        return dots;
    }

    /**
     * THis method initializes board by creating array of placeholder values.
     */
    private void init() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dots[i][j] = placeHolder;
            }
        }
    }

    /**
     * Makes output of array values to console.
     */
    @Override
    public void draw() {
        Arrays.stream(dots).forEach(x -> System.out.println(String.join("", x)));
    }
}
