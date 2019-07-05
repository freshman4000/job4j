package ru.job4j.loop;

/**
 * Class Fitness calculates number of month needed one bodybuilder to overtake another in dead lift.
 * @author Vit Efremov (freshman4000@gmail.com)
 * @since 04.07.2019.
 * @version 1.0.
 */
public class Fitness {
    /**
     * Month calculation.
     * @param ivan 1st bodybuilder.
     * @param nik 2nd bodybuilder.
     * @return number of month.
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while(ivan < nik) {
        ivan *= 3;
        nik *= 2;
        month++;
        }
        return month;
    }
}
