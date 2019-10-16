package ru.job4j.lsp.strategies;

import ru.job4j.lsp.products.FoodV2;
import ru.job4j.lsp.storages.StoragePlaceV2;

import java.util.ArrayList;
import java.util.List;

public class ControlQualityV3 extends ControlQualityV2 implements Resorting {
    /**
     * Constructor,
     *
     * @param heap    - products list, that needs to be separated to different storages, basing
     *                on quality and type.
     * @param storage storage that strategy uses.
     */
    public ControlQualityV3(List<FoodV2> heap, List<StoragePlaceV2> storage) {
        super(heap, storage);
    }

    /**
     * This method gathers all products from all storages to one heap,
     * clears storage foodList after getting all items from it, after all sets
     * newHeap and executes sorting strategy.
     */
    @Override
    public void resort() {
        List<FoodV2> collectionList = new ArrayList<>();
        for (StoragePlaceV2 sp : this.getStorageList()) {
            collectionList.addAll(sp.getStorage());
            sp.getStorage().clear();
        }
        this.setHeap(collectionList);
        this.sortProducts();
    }
}

