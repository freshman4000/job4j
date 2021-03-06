package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index;

    public SimpleArray(int size) {
        this.array = new Object[size];
        this.index = -1;
    }

    public void add(T model) {
        if (this.index < this.array.length - 1) {
            this.array[++this.index] = model;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void set(int index, T model) {
        if (this.index >= index) {
            this.array[index] = model;
        } else {
            throw new NoSuchElementException();
        }
    }

    public T get(int index) {
        if (this.index >= index) {
            return this.array[index] != null ? (T) this.array[index] : null;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove(int index) {
        if (this.index >= index) {
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        } else {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        String result = "";
        for (Object o : array) {
            result += " " + o;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int position = -1;

            @Override
            public boolean hasNext() {

                return position < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[++position];
            }
        };
    }

    public int size() {
        return index;
    }
}
