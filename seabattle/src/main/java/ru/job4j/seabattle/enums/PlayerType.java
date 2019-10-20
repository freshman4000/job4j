package ru.job4j.seabattle.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PlayerType specification.
 */
public enum PlayerType {
    HUMAN("Human"),
    AI("Computer");

    PlayerType(String label) {
    }

    public static List<Enum> getTypes() {
        return new ArrayList<>(Arrays.asList(HUMAN, AI));
    }
}
