package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Figure {

    public BishopWhite(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if ((Math.abs(source.x - dest.x) != Math.abs(source.y - dest.y))) {
            throw new ImposibleMoveException();
        }
        int length = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[length];
        int incrX = dest.x < source.x ?  -1 : 1;
        int incrY = dest.y < source.y ?  -1 : 1;
        for (int i = 1; i != length + 1; i++) {
            steps [i - 1] = findCell(source.x + incrX * i, source.y + incrY * i);
            }
        return steps;
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
