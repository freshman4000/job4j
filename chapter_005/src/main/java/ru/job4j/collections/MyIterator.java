package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator {
    private final int[][] array;
    private int indexR;
    private int indexC;

    public MyIterator(final int[][] array) {
        this.array = array;
        this.indexR = 0;
        this.indexC = 0;
    }

    @Override
    public boolean hasNext() {
        return indexR <= array.length - 1 && indexC <= array[indexR].length - 1;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int result = array[indexR][indexC++];
        if (indexC == array[indexR].length && indexR < array.length - 1) {
            indexR++;
            indexC = 0;
        }
        return result;
    }
}
