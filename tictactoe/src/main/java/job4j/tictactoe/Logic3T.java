package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean checker(String mark) {
    int[][] matrix = {{0, 0, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 1, 1},
            {this.table.length - 1, 0, -1, 1},
            {this.table.length - 1, 0, 0, 1},
            {this.table.length - 1, this.table.length -1, -1, 0},
            {1, 0, 0, 1},
            {0, 1, 1, 0}};
    return Arrays.stream(matrix)
            .anyMatch(subArray -> fillBy(c -> mark.equals("X") ? c.hasMarkX() : c.hasMarkO(),
                    subArray[0], subArray[1], subArray[2], subArray[3]));
    }

    public boolean isWinnerX() {
        return checker("X");
    }

    public boolean isWinnerO() {
        return checker("O");
    }

    public boolean hasGap() {
       return Arrays.stream(table).flatMap(Arrays::stream).anyMatch(x -> !x.hasMarkX() && !x.hasMarkO());
    }
}
