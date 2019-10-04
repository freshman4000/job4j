package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;

import java.util.List;

/**
 * Class that represents warehouse place.
 */
public class Warehouse implements StoragePlace<Food> {
    /**
     * List of food positions, currently stored in warehouse.
     */
    private List<Food> wareStorage;
    /**
     * Storage capacity.
     */
    private int capacity;

    public Warehouse(List<Food> wareStorage, int capacity) {
        this.wareStorage = wareStorage;
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method gets the list of products from warehouse.
     *
     * @return list of products in storage.
     */
    @Override
    public List<Food> getStorage() {
        return wareStorage;
    }

    /**
     * This method adds product to storage.
     *
     * @param item product object.
     */
    @Override
    public void addToStorage(Food item) {
        item.setId(wareStorage.size());
        wareStorage.add(item);
    }

    /**
     * This method removes product from storage.
     *
     * @param id product object id.
     */
    @Override
    public void removeFromStorage(int id) {
        wareStorage.remove(id);
    }
}
