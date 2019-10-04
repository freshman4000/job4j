package ru.job4j.lsp.storages;

import java.util.List;

/**
 * Interface, which proposes main methods required for any storage place.
 *
 * @param <T> represents for what type of items storage is used for.
 */
public interface StoragePlace<T> {
    /**
     * Add item to storage.
     *
     * @param item item.
     */
    void addToStorage(T item);

    /**
     * REmove item to storage.
     *
     * @param id of the item.
     */
    void removeFromStorage(int id);

    /**
     * Get list of all items, that are currently in storage.
     *
     * @return list of items.
     */
    List<T> getStorage();

    /**
     * This method gets capacity of the storage.
     *
     * @return int value of capacity.
     */
    int getCapacity();

    /**
     * This method should print message, when capacity of storage is close to its maximum.
     */
    default void executeCapacityCaution() {
        System.out.println("Attention! Low capacity!");
    }
}
