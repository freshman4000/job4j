package ru.job4j.phonebook;

import java.util.HashMap;
import java.util.List;

/**
 * Class that converts list of user to HashMap, with key corresponding to Users id, and value
 * that equals User.
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getId(), user);
        }
        return userMap;
    }
}
