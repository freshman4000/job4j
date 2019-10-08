package ru.job4j.lsp.storages;

import java.util.List;

public abstract class StoragePlace<T> {
    abstract public void add(T item);
    abstract public List<T> getStorage();
}
