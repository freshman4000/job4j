package ru.job4j.loop;

/**
 * Class Mortage calculates number of years needed to pay out credit.
 */
public class Mortage {
    /**
     * Method year calculates number of years.
     * @param amount of credit.
     * @param monthly payment.
     * @param percent yearly
     * @return number of years.
     */
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        while(amount > 0) {
            amount = (int)(amount + (amount * percent / 100) - monthly * 12);
            year++;
        }
        return year;
    }
}
