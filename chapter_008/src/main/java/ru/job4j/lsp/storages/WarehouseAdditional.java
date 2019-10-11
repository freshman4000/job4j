package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.FoodV2;

import java.util.List;

public class WarehouseAdditional extends StoragePlaceV2 {

    private List<FoodV2> foodList;

    public WarehouseAdditional(int capacity, List<FoodV2> foodList) {
        super(capacity);
        this.foodList = foodList;
    }

    @Override
    public void add(FoodV2 item) {
    }

    @Override
    public List<FoodV2> getStorage() {
        return foodList;
    }
}
