package ru.job4j.lsp.strategies;

import ru.job4j.lsp.products.Food;
import ru.job4j.lsp.storages.StoragePlace;
import ru.job4j.lsp.validators.*;
import java.util.List;

/**
 * Class that executes storage strategy targeted to Food quality control.
 */
public class ControlQuality implements StorageStrategy {
    private List<Food> heap;
    private StoragePlace<Food> st1;
    private StoragePlace<Food> st2;
    private StoragePlace<Food> st3;

    /**
     * Constructor,
     * @param heap - products list, that needs to be separated to different storages, basing
     * on quality.
     * @param st1 first storage.
     * @param st2 second storage.
     * @param st3 third storage.
     */
    public ControlQuality(List<Food> heap, StoragePlace<Food> st1, StoragePlace<Food> st2, StoragePlace<Food> st3) {
        this.heap = heap;
        this.st1 = st1;
        this.st2 = st2;
        this.st3 = st3;
    }

    /**
     * Main strategy logic method, which uses logic to separate products.
     */
    @Override
    public void sortProducts() {
        for (Food product : heap) {
            if (new ValidationLauncher<>(new TrashValidation()).launchValidation(product)) {
                if (new ValidationLauncher<>(new CapacityValidator()).launchValidation(st3)) {
                    st3.addToStorage(product);
                    if ((double) st3.getStorage().size() / st3.getCapacity() > 0.75) {
                        st3.executeCapacityCaution();
                    }
                } else {
                    System.out.println("Trash is full!");
                }
            } else if (new ValidationLauncher<>(new WarehouseValidation()).launchValidation(product)) {
                if (new ValidationLauncher<>(new CapacityValidator()).launchValidation(st2)) {
                    st2.addToStorage(product);
                    if ((double) st2.getStorage().size() / st2.getCapacity() > 0.75) {
                        st2.executeCapacityCaution();
                    }
                } else {
                    System.out.println("Warehouse is full!");
                }
            } else {
                if (new ValidationLauncher<>(new DiscountValidation()).launchValidation(product)) {
                    product.setDiscount(10);
                }
                if (new ValidationLauncher<>(new CapacityValidator()).launchValidation(st1)) {
                    st1.addToStorage(product);
                    if ((double) st1.getStorage().size() / st1.getCapacity() > 0.75) {
                        st1.executeCapacityCaution();
                    }
                } else {
                    System.out.println("Shop is full!");
                }
            }
        }
    }
}
