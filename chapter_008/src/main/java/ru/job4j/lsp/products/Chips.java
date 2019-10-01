package ru.job4j.lsp.products;

/**
 * Class that is extended from Food. Represents food type - chips.
 */
public class Chips extends Food {
    /**
     * Class constructor.
     * @param name name of product.
     * @param expireDate shelf life expiration date.
     * @param createDate production date.
     * @param price selling price.
     * @param discount current discount.
     */
    public Chips(String name, String expireDate, String createDate, Double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
