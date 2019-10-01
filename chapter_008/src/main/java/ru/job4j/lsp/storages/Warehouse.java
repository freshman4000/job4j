package ru.job4j.lsp.storages;

import ru.job4j.lsp.StorageStrategy;
import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.validating.WarehouseValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents warehouse database and its filling method(s).
 */
public class Warehouse implements StorageStrategy<Food> {
    /**
     * List of food items stored in current warehouse database.
     */
    private List<Food> warehouseStorage = new ArrayList<>();

    /**
     * This method gets current warehouse database.
     * @return current warehouse database.
     */
    public List<Food> getStorage() {
        return warehouseStorage;
    }

    /**
     * Method that picks Food objects from whole database and adds them to warehouse database.
     * @param products list of objects that need to be splited into groups.
     */
    @Override
    public void sortProducts(List<Food> products) {
        for (Food item : products) {
            if (new WarehouseValidation().validateByCriteria(item)) {
                warehouseStorage.add(item);
            }
        }
    }
}
