package ru.job4j.phonebook;

public class User1 implements Comparable<User1> {
    private String name;
    private int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User1 o) {
        return this.age - o.age;
    }
}
