package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveException;

import java.util.Arrays;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Figure {

    public BishopBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException{
        if ((Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y))) {
            throw new ImposibleMoveException();
        }
        int length = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[length];
        int incrX = dest.x < source.x ?  -1 : 1;
        int incrY = dest.y < source.y ?  -1 : 1;
        for (int i = 1; i != length + 1; i++) {
            for(Cell cell : Cell.values()) {
                if (cell.x == source.x + incrX * i && cell.y == source.y + incrY * i) {
                    steps[i - 1] = cell;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
