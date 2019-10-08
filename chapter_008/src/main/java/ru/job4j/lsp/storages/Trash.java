package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.validators.TrashValidation;

import java.util.List;

public class Trash extends StoragePlace<Food> {
    private List<Food> foodList;

    public Trash(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void add(Food item) {
        if (new TrashValidation().validateByCriteria(item)) {
            foodList.add(item);
        }
    }

    @Override
    public List<Food> getStorage() {
        return foodList;
    }
}