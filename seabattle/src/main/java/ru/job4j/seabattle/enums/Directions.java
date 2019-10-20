package ru.job4j.seabattle.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Directions specification.
 */
public enum Directions {
    WEST,
    EAST,
    SOUTH,
    NORTH;

    public static List<Enum> getDirections() {
        return new ArrayList<>(Arrays.asList(WEST, EAST, SOUTH, NORTH));
    }
}