package ru.job4j.lsp.validators;

import ru.job4j.lsp.storages.StoragePlaceV2;

/**
 * This class validates that storage has place for items to store.
 */
public class CapacityValidator implements Validation<StoragePlaceV2> {
    @Override
    public boolean validateByCriteria(StoragePlaceV2 item) {
        return item.getStorage().size() < item.getCapacity();
    }
}
