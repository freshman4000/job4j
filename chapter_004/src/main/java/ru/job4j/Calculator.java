package ru.job4j;
import java.util.function.*;

/**
 * Class that makes num calcs using lambdas.
 */
public class Calculator {
    /**
     * Multifunctional method to calculate math expressions consisted of two incoming parameters.
     * @param start bottom range of cycle.
     * @param finish upper range of cycle.
     * @param value which is used for calculation.
     * @param op functional interface.
     * @param media functional interface.
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
                    media.accept(op.apply(value, index));
        }
    }
}