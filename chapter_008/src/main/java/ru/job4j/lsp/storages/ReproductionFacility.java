package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.FoodV2;
import ru.job4j.lsp.validators.CapacityValidator;
import ru.job4j.lsp.validators.TrashValidation;

import java.util.List;

public class ReproductionFacility extends StoragePlaceV2 {
    private List<FoodV2> foodList;

    public ReproductionFacility(int capacity, List<FoodV2> foodList) {
        super(capacity);
        this.foodList = foodList;
    }

    @Override
    public void add(FoodV2 item) {
        if (new TrashValidation().validateByCriteria(item) && item.canRep()
                && new CapacityValidator().validateByCriteria(this)) {
            foodList.add(item);
        }
    }

    @Override
    public List<FoodV2> getStorage() {
        return foodList;
    }
}

