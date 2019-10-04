package ru.job4j.lsp.products;

import ru.job4j.lsp.utility.DateManager;

import java.util.Date;
import java.util.Objects;

/**
 * Class that represents food at all forms.
 */
public class Food {
    /**
     * Id of the product.
     */
    private int id;
    /**
     * Name of food.
     */
    private String name;
    /**
     * Shelf life expiration date.
     */
    private Date expireDate;
    /**
     * Date of production.
     */
    private Date createDate;
    /**
     * Price of food object.
     */
    private Double price;
    /**
     * Current discount on price of food object.
     */
    private int discount;

    /**
     * Class constructor.
     *
     * @param name       name of food object.
     * @param expireDate - shelf life expiration date.
     * @param createDate - date of production of the food object.
     * @param price      - price of the food object.
     * @param discount   - current discount on price of the food object.
     */
    public Food(String name, String expireDate, String createDate, Double price, int discount) {
        this.name = name;
        this.expireDate = DateManager.convertDate(expireDate);
        this.createDate = DateManager.convertDate(createDate);
        this.price = price;
        this.discount = discount;
    }

    /**
     * Name getter.
     *
     * @return name of food object.
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Shelf life expiration date getter.
     *
     * @return Shelf life expiration date of food object.
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * Shelf life expiration date setter.
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Product production date getter.
     *
     * @return Production date of food object.
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Production date setter.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Food object price getter.
     *
     * @return price of food object.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Food object price setter.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Price discount getter.
     *
     * @return price discount for food object.
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Price discount setter.
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * id getter.
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * id setter.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return id == food.id
                && discount == food.discount
                && name.equals(food.name)
                && expireDate.equals(food.expireDate)
                && createDate.equals(food.createDate)
                && price.equals(food.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expireDate, createDate, price, discount);
    }

    @Override
    public String toString() {
        return "id=" + id + " name = " + this.getName() + " price = " + this.getPrice() + " discount = " + this.getDiscount() + " create = " + this.getCreateDate() + " exp = " + this.getExpireDate() + System.lineSeparator();
    }
}
