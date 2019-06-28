package ru.job4j.condition;
/**
 * Class MultiMax calculates the biggest number out of three given.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 29.06.2019.
 * @version 1.0.
 */
public class MultiMax {
    /**
     * Method picks one biggest number out of three given.
     * @param first value.
     * @param second value.
     * @param third value.
     * @return biggest number value.
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        return result > third ? result : third;
    }
}