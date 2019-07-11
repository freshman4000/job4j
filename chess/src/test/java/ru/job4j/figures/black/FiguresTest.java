package ru.job4j.figures.black;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveException;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.PawnWhite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FiguresTest {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void before() {
        System.setOut(new PrintStream(out));
    }

    public void after() {
        System.setOut(stdout);
    }
    public void diagonalFigTest(Figure figure) throws ImposibleMoveException {
        Assert.assertThat(figure.way(figure.position, Cell.H8), Is.is(new Cell[]{Cell.E5, Cell.F6, Cell.G7, Cell.H8}));
    }
    public void xCoordFigTest(Figure figure) throws ImposibleMoveException {
        Assert.assertThat(figure.way(figure.position, Cell.H4), Is.is(new Cell[]{Cell.E4, Cell.F4, Cell.G4, Cell.H4}));
    }
    public void yCoordFigTest(Figure figure) throws ImposibleMoveException {
        Assert.assertThat(figure.way(figure.position, Cell.D1), Is.is(new Cell[]{Cell.D3, Cell.D2, Cell.D1}));
    }
    public void allWaysOneCellFigTest(Figure figure) throws ImposibleMoveException {
        Assert.assertThat(figure.way(figure.position, Cell.D3), Is.is(new Cell[]{Cell.D3}));
        Assert.assertThat(figure.way(figure.position, Cell.D5), Is.is(new Cell[]{Cell.D5}));
        Assert.assertThat(figure.way(figure.position, Cell.E4), Is.is(new Cell[]{Cell.E4}));
        Assert.assertThat(figure.way(figure.position, Cell.C4), Is.is(new Cell[]{Cell.C4}));
        Assert.assertThat(figure.way(figure.position, Cell.C3), Is.is(new Cell[]{Cell.C3}));
        Assert.assertThat(figure.way(figure.position, Cell.E3), Is.is(new Cell[]{Cell.E3}));
        Assert.assertThat(figure.way(figure.position, Cell.C5), Is.is(new Cell[]{Cell.C5}));
        Assert.assertThat(figure.way(figure.position, Cell.E5), Is.is(new Cell[]{Cell.E5}));
    }
    public void allKnightWaysCellFigTest(Figure figure) throws ImposibleMoveException {
        Assert.assertThat(figure.way(figure.position, Cell.C2), Is.is(new Cell[]{Cell.C2}));
        Assert.assertThat(figure.way(figure.position, Cell.B3), Is.is(new Cell[]{Cell.B3}));
        Assert.assertThat(figure.way(figure.position, Cell.B5), Is.is(new Cell[]{Cell.B5}));
        Assert.assertThat(figure.way(figure.position, Cell.C6), Is.is(new Cell[]{Cell.C6}));
        Assert.assertThat(figure.way(figure.position, Cell.E2), Is.is(new Cell[]{Cell.E2}));
        Assert.assertThat(figure.way(figure.position, Cell.F3), Is.is(new Cell[]{Cell.F3}));
        Assert.assertThat(figure.way(figure.position, Cell.F5), Is.is(new Cell[]{Cell.F5}));
        Assert.assertThat(figure.way(figure.position, Cell.E6), Is.is(new Cell[]{Cell.E6}));
    }

    /**
     * Testing PawnBlack
     */
    @Test
    public void testPawnBlack() {
        Figure fig = new PawnBlack(Cell.D4);
        try {
            Assert.assertThat(fig.way(fig.position, Cell.D3), Is.is(new Cell[]{Cell.D3}));
        } catch (ImposibleMoveException e) {
            e.printStackTrace();
        }
    }
    /**
     * Testing PawnWhite
     */
    @Test
    public void testPawnWhite() throws ImposibleMoveException {
        Figure fig = new PawnWhite(Cell.D4);

        Assert.assertThat(fig.way(fig.position, Cell.D5), Is.is(new Cell[]{Cell.D5}));
    }
    /**
     * Testing Bishop
     */
    @Test
    public void testBishop() throws ImposibleMoveException {
        Figure fig = new BishopBlack(Cell.D4);
        diagonalFigTest(fig);
    }
    /**
     * Testing Rook
     */
    @Test
    public void testRook() throws ImposibleMoveException {
        Figure fig = new RookBlack(Cell.D4);
        xCoordFigTest(fig);
        yCoordFigTest(fig);
    }
    /**
     * Testing Queen.
     */
    @Test
    public void testQueen() throws ImposibleMoveException {
        Figure fig = new QueenBlack(Cell.D4);
        xCoordFigTest(fig);
        yCoordFigTest(fig);
        diagonalFigTest(fig);
    }
    /**
     * Testing King.
     */
    @Test
    public void testKing() throws ImposibleMoveException {
        Figure fig = new KingBlack(Cell.D4);
        allWaysOneCellFigTest(fig);
    }
    /**
     * Testing Knight.
     */
    @Test
    public void testKnight() throws ImposibleMoveException {
        Figure fig = new KnightBlack(Cell.D4);
        allKnightWaysCellFigTest(fig);
    }
}

