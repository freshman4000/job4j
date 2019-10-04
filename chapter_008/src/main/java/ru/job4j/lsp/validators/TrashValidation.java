package ru.job4j.lsp.validators;

import ru.job4j.lsp.products.Food;

import java.util.Date;
/**
 * Class, that validates item acceptance to trash.
 */
public class TrashValidation implements Validation<Food> {
    /**
     * This method checks if Food item shelf life passed 100 percent of its value or not.
     * @param item - object for validation.
     * @return boolean value if shelf life of product passed 100 percent of its value
     * starting from production date.
     */
    @Override
    public boolean validateByCriteria(Food item) {
        boolean result = false;
        Date today = new Date();

        if (today.after(item.getExpireDate())) {
            result = true;
        }
        return result;
    }
}
