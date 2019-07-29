package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements Iterable<E>{
    private int index;
    private int modCount;
    private E[] array;

    public SimpleArrayList() {
        this.index = -1;
        this.modCount = 0;
        this.array = (E[])new Object[10];
    }
    public SimpleArrayList(int size) {
        this.index = -1;
        this.array = (E[])new Object[size];
    }
    private void increaseCap() {
        E[] buffer =(E[])new Object[array.length * 2];
        System.arraycopy(array, 0, buffer, 0, this.index);
        array = buffer;
    }
    public void add(E value) {
        modCount++;
        if (++index > array.length - 1) {
            increaseCap();
        }
        array[index] = value;
    }
    public E get(int index) {
        if (index > this.index - 1) {
            throw new NoSuchElementException();
        }
        return array[index];
    }
    public int size() {
        return index;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int position = -1;

            @Override
            public boolean hasNext() {
                return position < index;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[++position];
            }
        };
    }
}
