package ru.job4j.tictactoe.utilities;

/**
 * This class transforms String array to int array.
 */
public class StingToIntMatrixTransformer implements Transformer<int[][]> {
private String[][] dots;

    public StingToIntMatrixTransformer(String[][] dots) {
        this.dots = dots;
    }

    /**
     * Transforms String values of X and O letters to
     * 1 and -1 integer values respectively.
     * @return int array.
     */
    @Override
    public int[][] transform() {
        int[][] result = new int[dots.length][dots.length];
    for (int i = 0; i < dots.length; i++) {
        for (int j = 0; j < dots[0].length; j++) {
           if (dots[i][j].equals("X")) {
               result[i][j] = 1;
           } else if (dots[i][j].equals("O")) {
               result[i][j] = -1;
           }
        }
    }
    return result;
    }
}
