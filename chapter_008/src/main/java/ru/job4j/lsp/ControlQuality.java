package ru.job4j.lsp;

import java.util.List;

/**
 * Adapter class.
 * @param <T> typeParameter of data used by this class.
 */
public class ControlQuality<T> {
    /**
     * Variable, that should be passed to class constructor in moment of class object creation.
     */
    private StorageStrategy<T> storageStrategy;

    /**
     * Class constructor.
     * @param storageStrategy passed StorageStrategy object.
     */
    public ControlQuality(StorageStrategy<T> storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    /**
     * Main action method.
     * @param items whole items database.
     */
    public void executeStorageStrategy(List<T> items) {
        storageStrategy.sortProducts(items);
    }
}
