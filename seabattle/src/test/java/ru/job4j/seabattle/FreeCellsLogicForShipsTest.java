package ru.job4j.seabattle;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.seabattle.enums.Directions;
import ru.job4j.seabattle.logic.Logic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FreeCellsLogicForShipsTest {


    @Test
    public void when2PointsAvailableThen2InMap() {
        int[][] field = new int[][]{
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        Logic <Map<List<int[]>, Enum>> logic = null;
        Map<List<int[]>, Enum> freeCells = logic.executeLogic();
        Map<List<int[]>, Enum> expected = new LinkedHashMap<>();
        expected.put(new ArrayList<>(List.of(new int[]{0, 0}, new int[]{0, 1})), Directions.EAST);
        expected.put(new ArrayList<>(List.of(new int[]{0, 1}, new int[]{0, 0})), Directions.WEST);
        Assert.assertThat(freeCells, Is.is(expected));
    }
    @Test
    public void whenNoPointsAvailableThenEmptyMap() {
        int[][] field = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        Logic <Map<List<int[]>, Enum>> logic = null;
        Map<List<int[]>, Enum> freeCells = logic.executeLogic();
        Assert.assertThat(freeCells.size(), Is.is(0));
    }
}