package ru.job4j.bank;

/**
 * Class that creates account and manipulates its values.
 */
public class Account {
    private double values;
    private String requisites;

    /**
     * Constructor.
     * @param values starting balance.
     * @param requisites all transferring info.
     */
    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    /**
     * Getter.
     * @return amount.
     */
    public double getValues() {
        return values;
    }

    /**
     * Getter.
     * @return requisites.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Transfers amount from one account to another.
     * @param dest destination account.
     * @param value to be transfered.
     * @return if transfer was successful.
     */
    public boolean transfer(Account dest, double value) {
        boolean result = false;
        if (dest != null && this.values > 0 && this.values >= value) {
            this.values -= value;
            dest.values += value;
            result = true;
        }
        return result;
    }

    /**
     * Calculates hashcode for Account.
     * @return hash.
     */
    @Override
    public int hashCode() {
        int result = 11;
        result = 23 * result * (int) values;
        result = 23 * result * requisites.hashCode();
        return result;
    }

    /**
     * Instantiates equality method for Account class instances.
     * @param obj object to compare.
     * @return if objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account account = (Account) obj;

        return this.values == account.values
                && this.requisites.equals(account.requisites);
    }
}
