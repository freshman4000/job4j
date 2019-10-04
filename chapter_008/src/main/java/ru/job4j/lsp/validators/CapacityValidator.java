package ru.job4j.lsp.validators;

import ru.job4j.lsp.storages.StoragePlace;

/**
 * This class validates that storage has place for items to store.
 */
public class CapacityValidator implements Validation<StoragePlace> {
    @Override
    public boolean validateByCriteria(StoragePlace item) {
        return item.getStorage().size() < item.getCapacity();
    }
}
