package ru.job4j.lsp.validators;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.products.FoodV2;

public class FridgeWarehouseValidator implements Validation<FoodV2> {
    private Validation<Food> whVal;

    public FridgeWarehouseValidator(Validation<Food> whVal) {
        this.whVal = whVal;
    }

    /**
     * This method validates if Food item should got to warehouse and is vegetable.
     *
     * @param item - object for validation.
     * @return boolean value.
     */
    @Override
    public boolean validateByCriteria(FoodV2 item) {
        boolean result = false;
        if (whVal.validateByCriteria(item) && item.isVeg()) {
            result = true;
        }
        return result;
    }
}