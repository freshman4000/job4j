package ru.job4j.loop;

/**
 * Class Factorial calculates factorial of given number.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 29.06.2019.
 * @version 1.0.
 */
public class Factorial {
    /**
     * Method calc calculates factorial of given param.
     * @param n type int.
     * @return factorial.
     */
    public int calc(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= (i + 1);
        }
        return result;
    }
}
