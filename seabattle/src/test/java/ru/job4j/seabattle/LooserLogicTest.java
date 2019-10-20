package ru.job4j.seabattle;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.seabattle.logic.Logic;

public class LooserLogicTest {
    int[][] field = new int[][] {
            {0, -1, -1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    @Test
    public void whenAllKilledThenFalse() {

        Logic logic = null;
        Assert.assertThat(logic.executeLogic(), Is.is(false));
    }
    @Test
    public void whenThereIsLiveThenTrue() {
        field[5][5] = 1;
        Logic logic = null;
        Assert.assertThat(logic.executeLogic(), Is.is(true));
    }
}