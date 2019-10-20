package ru.job4j.seabattle;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.seabattle.logic.Logic;

import java.util.List;

public class FiringLogicTest {


    @Test
    public void when1PointAvailableThen1InList() {
        int[][] field = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        Logic<List<int[]>> logic = null;
        List<int[]> readyToFireFreeCells = logic.executeLogic();
        int[] expected = new int[]{0, 0};
        Assert.assertThat(readyToFireFreeCells.get(0), Is.is(expected));
    }
}