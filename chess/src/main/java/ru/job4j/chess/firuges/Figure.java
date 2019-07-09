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
}
