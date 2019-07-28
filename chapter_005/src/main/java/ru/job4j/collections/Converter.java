package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class which Iterator iterates Integers from any number of iterators.
 */
public class Converter {

    /**
     * Method that makes iteration.
     *
     * @param its iterator of iterators.
     * @return super iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {
            Iterator current = its.next();

            /**
             * Checks if there are elements for iteration.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                boolean result = false;
                while (its.hasNext() || current.hasNext()) {
                    if (!current.hasNext()) {
                        current = its.next();
                    }
                    if (current.hasNext()) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            /**
             * Tries to return next value.
             * @return next value or exception.
             */
            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (Integer) current.next();
            }
        };
    }
}

