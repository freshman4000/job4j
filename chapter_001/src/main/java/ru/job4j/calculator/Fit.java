package ru.job4j.calculator;
/**
 * Class Fit for calculating ideal man or woman weight according to his(her) height.
 * @author Vit Efremov
 * @since 28.06.2019.
 * @version 1.0.
 */
public class Fit {
    /**
     * Method that calculates ideal mans weight.
     * @param height type double.
     * @return ideal mans weight type double.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }
    /**
     * Method that calculates ideal woman weight.
     * @param height type double.
     * @return ideal woman weight type double.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
