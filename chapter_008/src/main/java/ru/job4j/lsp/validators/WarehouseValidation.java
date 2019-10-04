package ru.job4j.lsp.validators;

import ru.job4j.lsp.products.Food;

import java.util.Date;

/**
 * Class, that validates item acceptance to warehouse.
 */
public class WarehouseValidation implements Validation<Food> {
    /**
     * This method checks if Food item shelf life passed 25 percent of its value or not.
     * @param item - object for validation.
     * @return boolean value if shelf life of product is within 25 percent of its value
     * starting from production date.
     */
    @Override
    public boolean validateByCriteria(Food item) {
        boolean result = false;
        Date today = new Date();
        if (((double) (today.getTime() - item.getCreateDate().getTime())
                / (double) (item.getExpireDate().getTime() - item.getCreateDate().getTime())) * 100 < 25) {
            result = true;
        }
        return result;
    }
}
