package ru.job4j.tictactoe.logic;

import ru.job4j.tictactoe.utilities.StingToIntMatrixTransformer;
import ru.job4j.tictactoe.utilities.Transformer;

import java.util.Arrays;

/**
 * This class object is used to check, if winning combo occured or not.
 */
public class WinnerLogic implements Logic<String> {
    private String[][] array;
    private Transformer<int[][]> transformer;

    public WinnerLogic(String[][] array, Transformer<int[][]> transformer) {
        this.array = array;
        this.transformer = transformer;
    }

    /**
     * This method transforms string values of the board matrix to matrix, containing integer values 1 or -1.
     * 1 goes for X and -1 goes for O. After transformation, it checks if matrix has places, not filled with numbers. If so -
     * it sums existing numbers from each possible winning combination, and checks if
     * sum equals to board length (winning number).
     *
     * @return if matrix has no free space and no winning combo - this method will return "full", if spaces are available and
     * no winning combo - returns "N", if it has winning combo - it will return X or O, depending on winning sum sign.
     */
    public String executeLogic() {
        String answer = "full";
        transformer = new StingToIntMatrixTransformer(array);
        int[][] dots = transformer.transform();
        if (Arrays.stream(dots).flatMapToInt(x -> Arrays.stream(x).map(Math::abs)).sum() != array.length * array.length) {
            int result = 0;
            for (int i = 0; i < dots.length; i++) {
                int current = Arrays.stream(dots[i]).sum();
                if (Math.abs(current) == dots.length) {
                    result = current;
                    break;
                }
            }
            if (Math.abs(result) != dots.length) {
                for (int i = 0; i < dots.length; i++) {
                    result = 0;
                    for (int j = 0; j < dots.length; j++) {
                        result += dots[j][i];
                    }
                    if (Math.abs(result) == dots.length) {
                        break;
                    }
                }
            }
            if (Math.abs(result) != dots.length) {
                result = 0;
                for (int j = 0; j < dots.length; j++) {
                    result += dots[j][j];
                }
            }
            if (Math.abs(result) != dots.length) {
                result = 0;
                int count = 0;
                for (int j = dots.length - 1; j >= 0; j--) {
                    result += dots[count++][j];
                }
            }
            answer = Math.abs(result) != dots.length ? "N" : result == -dots.length ? "O" : "X";
        }
        return answer;
    }
}