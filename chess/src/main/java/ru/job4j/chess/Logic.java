package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

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

    public boolean move(Cell source, Cell dest) {
        boolean rst = true;
        Cell[] steps = new Cell[0];
        int index = this.findBy(source);
        try {
            if (index == -1) {
                rst = false;
                throw new FigureNotFoundException();
            }
            steps = this.figures[index].way(source, dest);
            for (Cell cell : steps) {
                if (findBy(cell) != -1) {
                    rst = false;
                    throw new OcupiedWayException();
                }
            }
        } catch (ImposibleMoveException e) {
            System.out.println("Can't move like this");
        } catch (FigureNotFoundException fne) {
            System.out.println("Figure not found!");
        } catch (OcupiedWayException ocw) {
            System.out.println("Occupied way!");
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest) && rst) {
            this.figures[index] = this.figures[index].copy(dest);
        }
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
}
