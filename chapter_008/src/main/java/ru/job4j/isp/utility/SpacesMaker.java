package ru.job4j.isp.utility;

import ru.job4j.isp.menus.MenuItem;

/**
 * This class is responsible for making placeholders before each menu item,
 * depending on its level in a tree.
 */
public class SpacesMaker {
    public static String makeSpaces(MenuItem item) {
        String result = "";
        MenuItem cur = item;
        while (cur.getParent() != null) {
            result = result.concat("----");
            cur = cur.getParent();
        }
        return result;
    }
}
