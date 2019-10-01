package ru.job4j.lsp.storages;

import ru.job4j.lsp.StorageStrategy;
import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.validating.TrashValidation;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that represents trash database and its filling method(s).
 */
public class Trash implements StorageStrategy<Food> {
    /**
     * List of items stored in current trash database.
     */
    private List<Food> trashStorage = new ArrayList<>();
    /**
     * This method gets current trash database.
     * @return current trash database.
     */
    public List<Food> getStorage() {
        return trashStorage;
    }
    /**
     * Method that picks Food objects from whole database and adds them to Trash database.
     * @param products list of objects that needs to be splited into groups.
     */
    @Override
    public void sortProducts(List<Food> products) {
        for (Food item : products) {
            if (new TrashValidation().validateByCriteria(item)) {
                trashStorage.add(item);
            }
        }
    }
}

