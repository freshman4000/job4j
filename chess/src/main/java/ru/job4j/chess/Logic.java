package ru.job4j.chess;

import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.KingBlack;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OcupiedWayException, FigureNotFoundException {
        boolean rst = false;

            int index = findBy(source);
            if (index == -1) throw new FigureNotFoundException();
            try {
                rst = validateCopy(this.figures[index].way(source, dest), dest);
            } catch (ImposibleMoveException | OcupiedWayException e1) {
                System.out.println(e1.getMessage());
            }
            this.figures[index] = rst ? this.figures[index].copy(dest) : this.figures[index];
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position.equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    private boolean validateCopy(Cell[] dest, Cell destCell) throws OcupiedWayException {
        boolean result = true;
        if (dest.length > 0 ) {
            for (Figure figure : this.figures) {
                for (Cell cell : dest) {
                    if (!cell.equals(figure.position)){}
                    else throw new OcupiedWayException();
                }
            }
            if (!dest[dest.length - 1].equals(destCell)) {
                result = false;
            }
        }
        return result;
    }
}
