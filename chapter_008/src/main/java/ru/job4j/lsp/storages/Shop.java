package ru.job4j.lsp.storages;

import ru.job4j.lsp.StorageStrategy;
import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.validating.DiscountValidation;
import ru.job4j.lsp.validating.ShopValidation;

import java.util.ArrayList;
import java.util.List;
/**
 * Class that represents shop database and its filling method(s).
 */
public class Shop implements StorageStrategy<Food> {
    /**
     * List of items, currently stored in shop database.
     */
    private List<Food> shopStorage = new ArrayList<>();
    /**
     * Discount value for items, that have ending shelf life.
     */
    private int discount = 10;
    /**
     * This method gets current shop database.
     * @return current shop database.
     */
    public List<Food> getStorage() {
        return shopStorage;
    }
    /**
     * Method that picks Food objects from whole database and adds them to shop database.
     * @param products list of objects that needs to be splitted into groups.
     */
    @Override
    public void sortProducts(List<Food> products) {
        for (Food item : products) {
            if (new DiscountValidation().validateByCriteria(item)) {
                item.setDiscount(this.discount);
            }
            if (new ShopValidation().validateByCriteria(item)) {
                shopStorage.add(item);
            }
        }
    }
}

