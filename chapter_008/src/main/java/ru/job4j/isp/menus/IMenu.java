package ru.job4j.isp.menus;

import ru.job4j.isp.Show;

import java.util.List;

/**
 * Abstract class that has all necessary methods in it,
 * to initialise menu and get access to its items.
 */
public abstract class IMenu implements Show {
    public abstract void init();
    public abstract List<MenuItem> getMenuList();
}
