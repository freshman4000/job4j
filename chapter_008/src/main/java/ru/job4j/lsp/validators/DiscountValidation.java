package ru.job4j.lsp.validators;

import ru.job4j.lsp.products.Food;

import java.util.Date;
/**
 * Class, that validates item discount application.
 */
public class DiscountValidation implements Validation<Food> {
    /**
     * This method checks if Food item shelf life passed 75 percent of its value and didn't reach 100
     * percent of its value or not.
     * @param item - object for validation.
     * @return boolean value if shelf life of product passed 75 percent of its value
     * and didn't reach 100 percent of its value starting from production date .
     */
    @Override
    public boolean validateByCriteria(Food item) {
        boolean result = false;
        Date today = new Date();
        double timePercent = ((double) (today.getTime() - item.getCreateDate().getTime())
                / (double) (item.getExpireDate().getTime() - item.getCreateDate().getTime())) * 100;
        if (timePercent >= 75 && timePercent <= 100) {
            result = true;
        }
        return result;
    }
}
