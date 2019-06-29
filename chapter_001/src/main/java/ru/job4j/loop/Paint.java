package ru.job4j.loop;
import java.util.function.BiPredicate;

/**
 * Class Paint creates string that looks like pyramid if printed.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 29.06.2019.
 */
public class Paint {
    /**
     * Method forms string.
     * @param height of the right triangle.
     * @return String object.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Method forms string.
     * @param height of the left triangle.
     * @return String object.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Method forms string.
     * @param height of the pyramid.
     * @return String object.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}