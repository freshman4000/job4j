package ru.job4j.lsp.validating;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.Validation;

import java.util.Date;
/**
 * Class, that validates item acceptance to shop.
 */
public class ShopValidation implements Validation<Food> {
    /**
     * This method checks if Food item shelf life between 25 and 100 percent of its value or not.
     * @param item - object for validation.
     * @return boolean value if shelf life of product passed 25 percent of its value
     * and didn't reach 100 percent of its value starting from production date.
     */
    @Override
    public boolean validateByCriteria(Food item) {
        boolean result = false;
        Date today = new Date();
        double timePercent = ((double) (today.getTime() - item.getCreateDate().getTime())
                / (double) (item.getExpireDate().getTime() - item.getCreateDate().getTime())) * 100;
        if (timePercent >= 25 && timePercent <= 100) {
            result = true;
        }
        return result;
    }
}
