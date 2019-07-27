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
        array.set(getIndexById(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        array.remove(getIndexById(id));
        return true;
    }

    @Override
    public T findById(String id) {
        return array.get(getIndexById(id));
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
        if (result == -1) {
            throw new NoSuchElementException();
        }
        return result;
    }
}
