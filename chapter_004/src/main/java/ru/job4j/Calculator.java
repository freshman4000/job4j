package ru.job4j;

import java.util.function.*;

/**
 * Class that makes num calcs using lambdas.
 */
public class Calculator {
    /**
     * Multifunctional method to calculate math expressions consisted of two incoming parameters.
     *
     * @param start  bottom range of cycle.
     * @param finish upper range of cycle.
     * @param value  which is used for calculation.
     * @param op     functional interface.
     * @param media  functional interface.
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(0, 10, 2,
                (MathUtil::add),
                result -> System.out.println(result));
    }
}

class MathUtil {
    public static double add(int left, int second) {
        return left + second;
    }

    public static double div(int left, int second) {
        return left / second;
    }
}
