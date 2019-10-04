package ru.job4j.lsp;

import ru.job4j.lsp.strategies.StorageStrategy;

/**
 * This class launches any storage strategy.
 */
public class StrategyLauncher {
    private StorageStrategy strategy;

    public StrategyLauncher(StorageStrategy strategy) {
        this.strategy = strategy;
    }

    public void launch() {
        strategy.sortProducts();
    }
}
