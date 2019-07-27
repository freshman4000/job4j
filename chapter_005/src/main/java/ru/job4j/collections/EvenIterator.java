package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that iterates over even numbers in int array.
 */
public class EvenIterator implements Iterator {
    /**
     * Incoming array.
     */
    private int[] array;
    /**
     * Index of even number.
     */
    int index;

    /**
     * Constructor.
     *
     * @param array incoming array.
     */
    public EvenIterator(int[] array) {
        this.array = array;
        this.index = 0;
    }

    /**
     * Method that returns if there is next even number.
     *
     * @return boolean value.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < array.length; i++)
            if (array[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        return result;
    }
    /**
     * Method that return next even number in array.
     *
     * @return next even number.
     */
    @Override
    public Object next() {
        if (!hasNext()) throw new NoSuchElementException();
        int result = array[index];
        index++;
        return result;
    }
}
