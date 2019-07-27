package ru.job4j.collections.generics;

import ru.job4j.collections.SimpleArray;

public class RoleStore extends AbstractStore {

    public RoleStore(int size) {
        super(new SimpleArray<Role>(size));
    }
}
