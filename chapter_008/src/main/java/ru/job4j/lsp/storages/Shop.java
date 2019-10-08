package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.validators.DiscountValidation;
import ru.job4j.lsp.validators.ShopValidation;

import java.util.List;

public class Shop extends StoragePlace<Food> {
    private List<Food> foodList;

    public Shop(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void add(Food item) {
        if (new ShopValidation().validateByCriteria(item)) {
                if (new DiscountValidation().validateByCriteria(item)) {
                    item.setDiscount(10);
                }
                foodList.add(item);

        }
    }

    @Override
    public List<Food> getStorage() {
        return foodList;
    }
}
