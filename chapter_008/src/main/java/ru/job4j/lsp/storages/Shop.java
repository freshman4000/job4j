package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;

import java.util.List;
/**
 * Class that represents shop storage place.
 */
public class Shop implements StoragePlace<Food> {
    /**
     * List of food positions, currently stored in shop.
     */
    private List<Food> shopStorage;
    /**
     * Storage capacity.
     */
    private int capacity;

    public Shop(List<Food> shopStorage, int capacity) {
        this.shopStorage = shopStorage;
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method gets the list of products from shop.
     * @return list of products in storage.
     */
    @Override
    public List<Food> getStorage() {
        return shopStorage;
    }

    /**
     * This method adds product to storage.
     * @param item product object.
     */
    @Override
    public void addToStorage(Food item) {
        item.setId(shopStorage.size());
        shopStorage.add(item);
    }
    /**
     * This method removes product from storage.
     * @param id product object id.
     */
    @Override
    public void removeFromStorage(int id) {
    shopStorage.remove(id);
    }
}

