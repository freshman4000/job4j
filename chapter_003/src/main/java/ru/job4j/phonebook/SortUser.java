package ru.job4j.phonebook;

import java.util.*;

/**
 * Class used to sort lists of users.
 */
public class SortUser {
    /**
     * Method used to arrange set with comparable elements.
     *
     * @param list incoming list, that needs to be sorted.
     * @return sorted set.
     */
    public Set<User1> sort(List<User1> list) {
        TreeSet<User1> treeSet = new TreeSet<>(list);
        return treeSet;
    }

    /**
     * Sorts by name length is ascending order.
     *
     * @param list incoming list, that needs to be sorted.
     * @return list sorted by name length.
     */
    public List<User1> sortNameLength(List<User1> list) {
        Comparator<User1> c1 = new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(c1);
        return list;
    }

    /**
     * Sorts list first - by name in lex order, then - by age is ascending order.
     *
     * @param list incoming list that needs to be sorted.
     * @return list of sorted by name and age elements.
     */
    public List<User1> sortByAllFields(List<User1> list) {
        Comparator<User1> c1 = new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result == 0 ? o1.getAge() - o2.getAge() : result;
            }
        };
        list.sort(c1);
        return list;
    }
}
