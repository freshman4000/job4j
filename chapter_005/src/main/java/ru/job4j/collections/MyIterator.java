package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator {
    private final int[][] array;
    private int index;
    int cRow;
    int cLength;
    private int volume;

    public MyIterator(final int[][] array) {
        this.array = array;
        cRow = 0;
        cLength = -1;
        index = -1;
        volume = 0;
        for (int i = 0; i < array.length; i++) {
            volume += array[i].length;
        }
    }

    @Override
    public boolean hasNext() {
        return index < volume - 1;
    }

    @Override
    public Object next() {
        int result = 0;
        try {
           cLength++;
           index++;
           if (cLength == array[cRow].length) {
               cRow++;
               cLength = 0;
           }
           result = array[cRow][cLength];
       }
       catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("No such element");
       }
        return result;
    }
}
