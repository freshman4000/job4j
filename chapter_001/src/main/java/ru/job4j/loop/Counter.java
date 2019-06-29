package ru.job4j.loop;

/**
 * Class Counter calculates sum of even numbers in particular range.
 * @author Vit Efremov (freshman4000@gmail.com)/
 * @since 29.06.2019.
 * @version 1.0.
 */
public class Counter {
    /**
     * Method add calculates sum of even numbers in closed range.
     * @param start lower inclusive range border.
     * @param finish upper inclusive range border.
     * @return sum of even numbers.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
