package ru.job4j.collections.generics;

import java.util.Objects;

public abstract class Base {
    private final String id;

    protected Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;
        Base base = (Base) o;
        return getId().equals(base.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
