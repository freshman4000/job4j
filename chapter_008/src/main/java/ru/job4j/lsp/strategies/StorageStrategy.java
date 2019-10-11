package ru.job4j.lsp.strategies;

/**
 * Interface responsible for storage strategy.
 */
public interface StorageStrategy {
    /**
     * WinnerLogic method that splits objects between storages.
     */
    void sortProducts();
}
