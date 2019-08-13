package ru.job4j.collections.generics;

import ru.job4j.collections.SimpleArray;

public class UserStore extends AbstractStore {

    public UserStore(int size) {
        super(new SimpleArray<User>(size));
    }
}
