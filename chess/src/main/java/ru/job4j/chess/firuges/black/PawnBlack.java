package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveException;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack extends Figure {

    public PawnBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (dest.x != source.x || dest.y - source.y != -1) {
            throw new ImposibleMoveException();
        }
        return new Cell[] { dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
