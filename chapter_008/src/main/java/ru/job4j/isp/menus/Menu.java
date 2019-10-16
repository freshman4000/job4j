package ru.job4j.isp.menus;

import ru.job4j.isp.actions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is responsible for one particular type of menu.
 */
public class Menu implements IMenu {
    /**
     * List of root menu items.
     */
    private List<MenuItem> rootList = new LinkedList<>();
    /**
     * List of leaf menu items.
     */
    private List<MenuItem> menuList = new ArrayList<>();

    /**
     * This method, has to have in its body creation of any amount of root items.
     * after creation, those items are being added to rootList.
     * After addition, names are being assigned to those root menu items, by adding serial
     * number in front of the name, followed by whitespace.
     * After that all, other menu items are being created amd finally, items from root list
     * being passed to formMenuList method, that creates leaf items and add the to menuLIst.
     */
    @Override
    public void init() {
        MenuItem root1 = new MenuItem("Task", null, new DoNothingAction());
        MenuItem root2 = new MenuItem("Task", null, new DoNothingAction());
        rootList.add(root1);
        rootList.add(root2);
        for (int i = 1; i <= rootList.size(); i++) {
            rootList.get(i - 1).setName(i + " " + (rootList.get(i - 1).getName()));
        }

        MenuItem it1 = new MenuItem("Task", root2, new Action21());
        MenuItem it2 = new MenuItem("Task", root2, new Action22());
        MenuItem it3 = new MenuItem("Task", root2, new Action23());
        MenuItem it4 = new MenuItem("Task", root1, new DoNothingAction());
        MenuItem it5 = new MenuItem("Task", root1, new DoNothingAction());
        MenuItem it6 = new MenuItem("Task", it4, new Action111());
        MenuItem it7 = new MenuItem("Task", it4, new Action112());
        MenuItem it8 = new MenuItem("Task", it5, new Action121());
        MenuItem it9 = new MenuItem("Task", it5, new Action122());

        formMenuList(rootList);
    }

    /**
     * This method takes root menu items, passes them to cycle, checks if
     * item has at least one or more children, and if it has - calls .this method recursively,
     * if no children are presented, it adds those items to the menuList.
     * @param list rootLIst.
     */
    private void formMenuList(List<MenuItem> list) {
        for (MenuItem item : list) {
            if (item.getChildren().size() > 0) {
                formMenuList(item.getChildren());
            } else {
                menuList.add(item);
            }
        }
    }

    /**
     * This is getter method for menu list.
     * @return current menuList.
     */
    public List<MenuItem> getMenuList() {
        return menuList;
    }

    /**
     * This method is responsible for output of visual
     * item data to console.
     */
    @Override
    public void show() {
        for (MenuItem item : rootList) {
            item.show();
        }
    }
}