package ru.job4j.lsp.strategies;

import ru.job4j.lsp.storages.StoragePlace;

import java.util.List;

/**
 * Interface responsible for storage strategy.
 */
public interface StorageStrategy<T> {
    /**
     * Logic method that splits objects between storages.
     */
    void sortProducts();
    /**
     * Setter for heap;
     */
    void setHeap(List<T> newHeap);
    /**
     * Getter for storage.
     * @return list of storages.
     */
    List<StoragePlace> getStorageList();
}
