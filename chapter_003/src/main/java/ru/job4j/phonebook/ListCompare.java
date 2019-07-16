package ru.job4j.phonebook;

import java.util.Comparator;

/**
 * Class for comparing strings.
 */
public class ListCompare implements Comparator<String> {
    /**
     * Method compares every single character of strings.
     * @param left string.
     * @param right string.
     * @return comparison result type int (-1, 0, 1).
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = left.length() >= right.length() ? left.length() : right.length();
        for (int i = 0; i != length; i++) {
            result = (i != left.length() ? left.charAt(i) : ' ') -
                    (i != right.length() ? right.charAt(i) : ' ');
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}

