package ru.job4j.chess.firuges;

import ru.job4j.chess.Logic;

public class Board extends Logic {
    Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        super.add(figure);
    }
    public boolean move(Cell source, Cell dest) throws FigureNotFoundException {
    return super.move(source, dest);
    }
}
