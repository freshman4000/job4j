package ru.job4j.isp.menus;

import ru.job4j.isp.actions.Action;

/**
 * Abstract class that represents one unit of menu list. It
 * has one abstract method, that is responsible for the way this item is being
 * initialised and one abstract method for console output.
 */
public abstract class IMenuItem implements Action {
    abstract void init();
    abstract void show();
}
