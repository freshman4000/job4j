package ru.job4j.xmlxstlmagnit;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


public class Entry {
    private int id;
    @XmlElement
    private int field;

    public Entry() {
    }

    public Entry(int id, int field) {
        this.id = id;
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return id == entry.id
                && field == entry.field;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, field);
    }
}
