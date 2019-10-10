package ru.job4j.tictactoe;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;
import ru.job4j.tictactoe.logic.WinnerLogic;
import ru.job4j.tictactoe.utilities.StingToIntMatrixTransformer;

/**
 * Testing logic.
 */
public class WinnerLogicTest {
    /**
     * Testing horizontal X.
     */
    @Test
    public void when3XInRowThenReturnX() {
        String[][] array = new String[][]{
                {"X", "X", "X"},
                {" ", " ", " "},
                {" ", " ", " "}
        };
       String result = new WinnerLogic(array, new StingToIntMatrixTransformer(array)).executeLogic();
       Assert.assertThat(result, Is.is("X"));
    }
    /**
     * Testing vertical O.
     */
    @Test
    public void when3OInColThenReturnO() {
        String[][] array = new String[][]{
                {"O", " ", " "},
                {"O", " ", " "},
                {"O", " ", " "}
        };
        String result = new WinnerLogic(array, new StingToIntMatrixTransformer(array)).executeLogic();
        Assert.assertThat(result, Is.is("O"));
    }
    /**
     * Testing first diagonal X.
     */
    @Test
    public void when3XInDiaThenReturnX() {
        String[][] array = new String[][]{
                {"X", " ", " "},
                {" ", "X", " "},
                {" ", " ", "X"}
        };
        String result = new WinnerLogic(array, new StingToIntMatrixTransformer(array)).executeLogic();
        Assert.assertThat(result, Is.is("X"));
    }
    /**
     * Testing second diagonal O.
     */
    @Test
    public void when3OInDiaThenReturnO() {
        String[][] array = new String[][]{
                {" ", " ", "O"},
                {" ", "O", " "},
                {"O", " ", " "}
        };
        String result = new WinnerLogic(array, new StingToIntMatrixTransformer(array)).executeLogic();
        Assert.assertThat(result, Is.is("O"));
    }
    /**
     * Testing no-win combo.
     */
    @Test
    public void when2XInDiaThenReturnN() {
        String[][] array = new String[][]{
                {"X", " ", " "},
                {" ", "X", " "},
                {" ", " ", " "}
        };
        String result = new WinnerLogic(array, new StingToIntMatrixTransformer(array)).executeLogic();
        Assert.assertThat(result, Is.is("N"));
    }
    /**
     * Testing full no-win combo.
     */
    @Test
    public void whenFullAndNoWinThenReturnFull() {
        String[][] array = new String[][]{
                {"X", "X", "O"},
                {"O", "X", "O"},
                {"X", "O", "O"}
        };
        String result = new WinnerLogic(array, new StingToIntMatrixTransformer(array)).executeLogic();
        Assert.assertThat(result, Is.is("full"));
    }
}