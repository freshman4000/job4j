package ru.job4j.isp.menus;

import java.util.List;

/**
 * Interface that has all necessary methods in it,
 * to initialise menu and get access to its items.
 */
public interface IMenu {
    void init();
    List<MenuItem> getMenuList();
    void show();
}
