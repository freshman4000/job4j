package ru.job4j.seabattle.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Battlefield fillers specification.
 */
public enum PlaceHolders {
    E(0),
    K(1),
    M(-1);

    PlaceHolders(int label) {
    }

    public static List<Enum> getPlaceHolders() {
        return new ArrayList<>(Arrays.asList(E, K, M));
    }
}
