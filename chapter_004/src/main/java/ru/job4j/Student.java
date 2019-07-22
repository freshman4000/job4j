package ru.job4j;

import java.util.Objects;

public class Student {
    private int score;
    private String name;
    private String lastName;

    public Student(int score, String name, String lastName) {
        this.score = score;
        this.name = name;
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getScore() == student.getScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore());
    }
}
