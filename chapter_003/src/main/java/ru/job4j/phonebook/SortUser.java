package ru.job4j.phonebook;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User1> sort (List<User1> list) {
        TreeSet<User1> treeSet = new TreeSet<>(list);
        return treeSet;
    }
}
