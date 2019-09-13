package ru.job4j.vacancyparser;

import java.sql.Timestamp;
import java.util.Objects;

public class Vacancy {
    Timestamp date;
    String name;
    String text;
    String reference;

    public Vacancy(Timestamp date, String name, String text, String reference) {
        this.date = date;
        this.name = name;
        this.text = text;
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return date.equals(vacancy.date)
                && name.equals(vacancy.name)
                && text.equals(vacancy.text)
                && reference.equals(vacancy.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name, text, reference);
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "date=" + date
                + ", name='" + name + '\''
                + ", text='" + text + '\''
                + ", reference='" + reference + '\''
                + '}';
    }
}
