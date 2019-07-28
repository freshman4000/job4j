package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements Iterable<E>{
    private int length;
    private int index;
    private int modCount;
    private E[] array;

    public SimpleArrayList() {
        this.length = 10;
        this.index = -1;
        this.modCount = 0;
        this.array = (E[])new Object[this.length];
    }
    public SimpleArrayList(int size) {
        this.length = size;
        this.index = -1;
        this.array = (E[])new Object[this.length];
    }

    public void add(E value) {
        modCount++;
        if (++index > length - 1) {
            E[] buffer =(E[])new Object[length * 2];
            System.arraycopy(array, 0, buffer, 0, this.index);
            array = buffer;
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
