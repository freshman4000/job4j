package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.FoodV2;
import ru.job4j.lsp.validators.CapacityValidator;
import ru.job4j.lsp.validators.FridgeWarehouseValidator;
import ru.job4j.lsp.validators.WarehouseValidation;

import java.util.List;

public class WarehouseFridge extends StoragePlaceV2 {
    private List<FoodV2> foodList;

    public WarehouseFridge(int capacity, List<FoodV2> foodList) {
        super(capacity);
        this.foodList = foodList;
    }

    @Override
    public void add(FoodV2 item) {
        if (new FridgeWarehouseValidator(new WarehouseValidation()).validateByCriteria(item)
                && new CapacityValidator().validateByCriteria(this)) {
            foodList.add(item);
        }
    }

    @Override
    public List<FoodV2> getStorage() {
        return foodList;
    }
}
