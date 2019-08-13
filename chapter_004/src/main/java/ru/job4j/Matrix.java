package ru.job4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    Integer[][] matrix = new Integer[4][10];

    public List<Integer> transform(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }

}
