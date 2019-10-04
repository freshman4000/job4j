package ru.job4j.lsp.storages;

import ru.job4j.lsp.products.Food;

import java.util.List;

/**
 * Class that represents trash place.
 */
public class Trash implements StoragePlace<Food> {
    /**
     * List of food positions, currently stored in trash.
     */
    private List<Food> trashStorage;
    /**
     * Storage capacity.
     */
    private int capacity;

    public Trash(List<Food> shopStorage, int capacity) {
        this.trashStorage = shopStorage;
        this.capacity = capacity;
    }

    /**
     * This method gets the list of products from trash.
     *
     * @return list of products in storage.
     */
    @Override
    public List<Food> getStorage() {
        return trashStorage;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method adds product to storage.
     *
     * @param item product object.
     */
    @Override
    public void addToStorage(Food item) {
        item.setId(trashStorage.size());
        trashStorage.add(item);
    }

    /**
     * This method removes product from storage.
     *
     * @param id product object id.
     */
    @Override
    public void removeFromStorage(int id) {
        trashStorage.remove(id);
    }
}

