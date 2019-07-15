package ru.job4j.phonebook;

/**
 * Class User with fields.
 */
public class User {
    private int id;
    private String name;
    private String city;

    /**
     * Constructor.
     *
     * @param id   users id.
     * @param name users name.
     * @param city users city.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Getter for users id.
     *
     * @return users id.
     */
    public int getId() {
        return id;
    }
}
