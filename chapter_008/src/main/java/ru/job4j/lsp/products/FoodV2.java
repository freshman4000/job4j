package ru.job4j.lsp.products;

import ru.job4j.lsp.utility.DateManager;

import java.util.Objects;

public class FoodV2 extends Food {
    protected Food decoratedFood;
    protected boolean isVeg;
    protected boolean isRep;


    public FoodV2(boolean isVeg, boolean isRep, Food decoratedFood) {
        super(decoratedFood.getName(), DateManager.convertDate(decoratedFood.getExpireDate()), DateManager.convertDate(decoratedFood.getCreateDate()), decoratedFood.getPrice(), decoratedFood.getDiscount());
        this.decoratedFood = decoratedFood;
        this.isVeg = isVeg;
        this.isRep = isRep;
    }

    public FoodV2(String name, String expireDate, String createDate, Double price, int discount, boolean isVeg, boolean isRep) {
        super(name, expireDate, createDate, price, discount);
        this.isVeg = isVeg;
        this.isRep = isRep;
    }

    public boolean canRep() {
        return isRep;
    }

    public boolean isVeg() {
        return isVeg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FoodV2 foodV2 = (FoodV2) o;
        return isVeg == foodV2.isVeg
                && isRep == foodV2.isRep
                && Objects.equals(decoratedFood, foodV2.decoratedFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), decoratedFood, isVeg, isRep);
    }
}
