package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.validators.WarehouseValidation;

import java.util.List;

public class WareHouse extends StoragePlace<Food> {
    private List<Food> foodList;

    public WareHouse(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void add(Food item) {
        if (new WarehouseValidation().validateByCriteria(item)) {
            foodList.add(item);
        }
    }

    @Override
    public List<Food> getStorage() {
        return foodList;
    }
}