package ru.job4j.seabattle.utility;

import java.util.List;
import java.util.Map;

/**
 * This class describes all conditions, under which the game will take place.
 */
public interface Rules {
    void setFieldSize();

    void setShipTypesNumber();

    void setSectionsForEachType();

    int[] getFieldSize();

    Map<Integer, Integer> getSectionsForEachType();

    List<Enum> getPlaceHolders();
}
