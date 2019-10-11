package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.FoodV2;

public abstract class StoragePlaceV2 extends StoragePlace<FoodV2> {
    private int capacity;
    private StoragePlace<Food> storagePlace;

    public StoragePlaceV2(StoragePlace<Food> storagePlace, int capacity) {
        this.storagePlace = storagePlace;
        this.capacity = capacity;
    }

    public StoragePlaceV2(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
