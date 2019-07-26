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
            Iterator curIt = setCurIt();

            /**
             * Method, that sets current iterator and if current iterator doesn't have next() value,
             * makes recursive call of the method till it returns Iterator which has next value or null.
             * @return new current iterator or null.
             */
            private Iterator setCurIt() {
                Iterator result = null;
                if (its.hasNext()) {
                    result = its.next();
                }
                return result != null ? result.hasNext() ? result : setCurIt() : null;
            }

            /**
             * Checks if current iterator has next value and calls setCurrentIterator method
             * if there is no next value.
             * @return current iterator.
             */
            private Iterator checkState() {
                return curIt = curIt.hasNext() ? curIt : setCurIt();
            }

            /**
             * Checks if current iterator has next value.
             * @return true or false.
             */
            @Override
            public boolean hasNext() {
                return curIt != null;
            }

            /**
             * Method that returns next value in the global row or throws exception.
             * @return next() value.
             */
            @Override
            public Integer next() {
                int result;
                if (curIt != null && curIt.hasNext()) {
                    result = (Integer) curIt.next();
                    curIt = checkState();
                } else if ((curIt = setCurIt()) != null) {
                    result = (Integer) curIt.next();
                    curIt = checkState();
                } else {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}

