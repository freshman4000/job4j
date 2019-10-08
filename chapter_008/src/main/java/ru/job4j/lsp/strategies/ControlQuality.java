package ru.job4j.lsp.strategies;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.storages.StoragePlace;

import java.util.List;

/**
 * Class that executes storage strategy targeted to Food quality control.
 */
public class ControlQuality implements StorageStrategy {
    private List<Food> heap;
    private List<StoragePlace<Food>> storage;

    /**
     * Constructor,
     * @param heap - products list, that needs to be separated to different storages, basing
     * on quality.
     * @param storage storage that strategy uses.
     */
    public ControlQuality(List<Food> heap, List<StoragePlace<Food>> storage) {
        this.heap = heap;
        this.storage = storage;
    }

    /**
     * Main strategy logic method, which uses logic to separate products.
     */
    @Override
    public void sortProducts() {
        for (Food product : heap) {
            for (StoragePlace<Food> sp : storage) {
            sp.add(product);}
        }
    }
}
