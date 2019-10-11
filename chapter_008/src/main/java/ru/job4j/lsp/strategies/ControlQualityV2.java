package ru.job4j.lsp.strategies;

import ru.job4j.lsp.products.FoodV2;
import ru.job4j.lsp.storages.StoragePlaceV2;

import java.util.List;

public class ControlQualityV2 implements StorageStrategy {
    private List<FoodV2> heap;
    private List<StoragePlaceV2> storage;

    /**
     * Constructor,
     *
     * @param heap    - products list, that needs to be separated to different storages, basing
     *                on quality and type.
     * @param storage storage that strategy uses.
     */
    public ControlQualityV2(List<FoodV2> heap, List<StoragePlaceV2> storage) {
        this.heap = heap;
        this.storage = storage;
    }

    /**
     * Main strategy logic method, which uses logic to separate products.
     */
    @Override
    public void sortProducts() {
        for (FoodV2 product : heap) {
            for (StoragePlaceV2 sp : storage) {
                sp.add(product);
            }
        }
    }
}
