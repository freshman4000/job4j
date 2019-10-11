package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.FoodV2;
import ru.job4j.lsp.validators.DiscountValidation;
import ru.job4j.lsp.validators.ShopValidation;

import java.util.List;

public class ShopV2 extends StoragePlaceV2 {
    private List<FoodV2> foodList;

    public ShopV2(StoragePlace<Food> storagePlace, int capacity, List<FoodV2> foodList) {
        super(storagePlace, capacity);
        this.foodList = foodList;
    }

    @Override
    public void add(FoodV2 item) {
        if (new ShopValidation().validateByCriteria(item)) {
            if (new DiscountValidation().validateByCriteria(item)) {
                item.setDiscount(10);
            }
            foodList.add(item);
        }
    }

    @Override
    public List<FoodV2> getStorage() {
        return foodList;
    }
}
