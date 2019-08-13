package ru.job4j.collections.set;

import ru.job4j.collections.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> sa;
    private boolean hasNull;

    public SimpleSet(int size) {
        this.sa = new SimpleArray<>(size);
        hasNull = false;
    }

    public boolean add(E data) {
        boolean result = true;
            for (int i = 0; i <= sa.size(); i++) {
                if (sa.get(i) != null && sa.get(i).equals(data)) {
                    result = false;
                    break;
                }
            }
            if (data == null && !hasNull) {
                hasNull = true;
            } else if (data == null && hasNull) {
                    result = false;
            }
        if (result) {
            sa.add(data);
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> it = sa.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public E next() {
                return it.next();
            }
        };
    }
}
