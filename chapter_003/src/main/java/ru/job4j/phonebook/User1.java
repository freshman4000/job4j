package ru.job4j.phonebook;

/**
 * Class that is used to create users with na,e and age specified.
 */
public class User1 implements Comparable<User1> {
    private String name;
    private int age;

    /**
     * Constructor.
     * @param name of the user.
     * @param age of the user.
     */
    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Age getter.
     * @return age number.
     */
    public int getAge() {
        return age;
    }

    /**
     * Name getter.
     * @return String value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Methos which compares two objects by age.
     * @param o object for comparison.
     * @return comparison result - type int (-1, 0, 1).
     */
    @Override
    public int compareTo(User1 o) {
        return this.age - o.age;
    }
}
