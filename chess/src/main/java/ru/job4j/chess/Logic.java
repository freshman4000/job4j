package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

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

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException {
        boolean rst = false;

        int index = findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
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

    /**
     * Method that checks that way() gave not null array of moves, checks if there are no
     * figures on the way, and that dest equals the last element in returned by way() array.
     * @param dest - array returned by way() method of figure.
     * @param destCell - destination cell of movement (from move() params).
     * @return boolean value if movement is possible.
     * @throws OcupiedWayException - if there are figures on the way of movement.
     */
    private boolean validateCopy(Cell[] dest, Cell destCell) throws OcupiedWayException {
        boolean result = true;
        if (dest.length > 0) {
            for (Figure figure : this.figures) {
                for (Cell cell : dest) {
                    if (!cell.equals(figure.position)) {
                        int xxx = 0;
                    } else {
                        throw new OcupiedWayException();
                    }
                }
            }
            if (!dest[dest.length - 1].equals(destCell)) {
                result = false;
            }
        }
        return result;
    }
}
