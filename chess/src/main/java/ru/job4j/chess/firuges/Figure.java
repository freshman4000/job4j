package ru.job4j.chess.firuges;

public abstract class Figure {
    public final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }
    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }
    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;
    public abstract Figure copy(Cell dest);

    public Cell findCell(int x, int y) {
        Cell result = null;
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                result = cell;
            }
        }
        return result;
    }
}
