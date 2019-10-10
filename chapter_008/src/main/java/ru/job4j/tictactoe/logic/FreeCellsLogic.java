package ru.job4j.tictactoe.logic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * THis class gets free cells from the board.
 */
public class FreeCellsLogic implements Logic<Map<Integer, int[]>> {
    private String[][] dots;

    public FreeCellsLogic(String[][] dots) {
        this.dots = dots;
    }

    /**
     * This method runs through an array and puts not occupied cells into linked
     * hash map: key - is position in list and value is 2 numbers int array, representing
     * cell position on the board.
     *
     * @return map.
     */
    @Override
    public Map<Integer, int[]> executeLogic() {
        Map<Integer, int[]> map = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[0].length; j++) {
                if (!dots[i][j].equals("X") && !dots[i][j].equals("O")) {
                    map.put(count++, new int[]{i, j});
                }
            }
        }
        return map;
    }
}