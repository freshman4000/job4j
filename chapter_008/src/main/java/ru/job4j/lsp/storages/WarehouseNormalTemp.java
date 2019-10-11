package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.FoodV2;
import ru.job4j.lsp.validators.CapacityValidator;
import ru.job4j.lsp.validators.WarehouseValidation;

import java.util.List;

public class WarehouseNormalTemp extends StoragePlaceV2 {
    private StoragePlaceV2 nextWhenFull;
    private List<FoodV2> foodList;

    public WarehouseNormalTemp(StoragePlace<Food> storagePlace, int capacity, List<FoodV2> foodList, StoragePlaceV2 nextWhenFull) {
        super(storagePlace, capacity);
        this.foodList = foodList;
        this.nextWhenFull = nextWhenFull;
    }

    @Override
    public void add(FoodV2 item) {
        if (new WarehouseValidation().validateByCriteria(item) && !item.isVeg()) {
            if (new CapacityValidator().validateByCriteria(this)) {
                foodList.add(item);
            } else {
                if (new CapacityValidator().validateByCriteria(nextWhenFull)) {
                    nextWhenFull.getStorage().add(item);
                }
            }
        }
    }

    @Override
    public List<FoodV2> getStorage() {
        return foodList;
    }
}
