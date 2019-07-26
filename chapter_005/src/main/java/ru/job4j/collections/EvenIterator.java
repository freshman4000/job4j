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
     * The amount of even numbers in array.
     */
    int length;
    /**
     * Array current index - refers from global iteration.
     */
    int overAll;

    /**
     * Constructor.
     *
     * @param array incoming array.
     */
    public EvenIterator(int[] array) {
        this.array = array;
        this.index = -1;
        this.length = 0;
        this.overAll = 0;
        for (int i = 0; i != this.array.length; i++) {
            if (array[i] % 2 == 0) {
                length++;
            }
        }
    }

    /**
     * Method that returns if there is next even number.
     *
     * @return boolean value.
     */
    @Override
    public boolean hasNext() {
        return this.index < this.length - 1;
    }

    /**
     * Method that return next even number in array.
     *
     * @return next even number.
     */
    @Override
    public Object next() {
        if (!hasNext()) throw new NoSuchElementException();
        int result = 0;
        for (int i = overAll; i != array.length; i++) {
            overAll++;
            if (array[i] % 2 == 0) {
                index++;
                result = array[i];
                break;
            }
        }
        return result;
    }
}
