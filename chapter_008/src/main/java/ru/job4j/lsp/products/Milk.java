package ru.job4j.lsp.products;

/**
 * Class that is extended from Food. Represents food type - milk.
 */
public class Milk extends Food {
    /**
     * Class constructor.
     * @param name name of product.
     * @param expireDate shelf life expiration date.
     * @param createDate production date.
     * @param price selling price.
     * @param discount current discount.
     */
    public Milk(String name, String expireDate, String createDate, Double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
