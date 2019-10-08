package ru.job4j.isp;

import java.util.Arrays;
import java.util.List;

public class MenuItem implements AddParent, AddChild, Show, GetParent {
    private String name;
    private MenuItem parent;
    private List<MenuItem> children;

    public MenuItem(String name, MenuItem parent, List<MenuItem> children) {
        this.name = name;
        this.parent = parent;
        this.children = children;
    }

    @Override
    public void addChild(MenuItem ...item) {
        children.addAll(Arrays.asList(item));
    }

    @Override
    public void addParent(MenuItem item) {
    parent = item;
    }

    @Override
    public void show() {
        System.out.println(this.name);
        if (this.children.size() != 0) {
            for (MenuItem item : children) {
                System.out.print(SpacesMaker.makeSpaces(item));
                item.show();
            }
        }
    }

    @Override
    public MenuItem getParent() {
        return this.parent;
    }
}
