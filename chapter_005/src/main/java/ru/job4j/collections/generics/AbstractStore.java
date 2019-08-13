package ru.job4j.collections.generics;

import ru.job4j.collections.SimpleArray;

import java.util.NoSuchElementException;

public class AbstractStore<T extends Base> implements Store<T> {
    public SimpleArray<T> array;

    public AbstractStore(SimpleArray<T> array) {
        this.array = array;
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndexById(id);
        if (index != -1) {
            array.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndexById(id);
        if (index != -1) {
            array.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        int index = getIndexById(id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return array.get(index);
    }

    /**
     * Utility method, that gets index of the element by id.
     *
     * @param id incoming id.
     * @return index.
     */
    private int getIndexById(String id) {
        int result = -1;
        for (int i = 0; i != array.size(); i++) {
            if (array.get(i).getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}