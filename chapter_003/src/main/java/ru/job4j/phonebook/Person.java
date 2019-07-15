package ru.job4j.phonebook;

/**
 * Class Person creates a person with particular attributes.
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    /**
     * Constructor.
     *
     * @param name    name.
     * @param surname surname.
     * @param phone   phone.
     * @param address address.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Surname getter.
     *
     * @return surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Phone getter.
     *
     * @return phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Address getter.
     *
     * @return address.
     */
    public String getAddress() {
        return address;
    }
}
