package ru.job4j.converter;
/**
 * class Converter converts one currency into another.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 28.06.2019.
 */
public class Converter {
    static final int EURO = 70;
    static final int USD = 60;
    /**
     * Rub to Euro conversion.
     * @param value amount in Rub.
     * @return amount in EURO.
     */
    public int rubleToEuro(int value) {
        return value / EURO;
    }
    /**
     * Rub to Usd conversion.
     * @param value amount in Rub.
     * @return amount in USD.
     */
    public int rubleToUsd(int value) {
        return value / USD;
    }
    /**
     * Euro to Rub conversion
     * @param value amount in EURO
     * @return amount in Rub
     */
    public int euroToRub(int value) {
        return value * EURO;
    }
    /**
     * Usd to Rub conversion
     * @param value amount in USD
     * @return amount in Rub
     */
    public int usdToRub(int value) {
        return value * USD;
    }
}
