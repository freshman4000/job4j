package ru.job4j.lsp;

import java.util.List;

/**
 * Interface responsible for storage strategy.
 * @param <T> typeParameter of objects, that will be stored.
 */
public interface StorageStrategy<T> {
    /**
     * Method that splits objects into groups.
     * @param products list of objects that need to be splited into groups.
     */
    void sortProducts(List<T> products);

    /**
     * This method should get StorageStrategy object group of products.
     * @return group of products.
     */
    List<T> getStorage();
}
