package ru.job4j.isp.menus;

import ru.job4j.isp.Show;
import ru.job4j.isp.utility.SpacesMaker;
import ru.job4j.isp.actions.Action;

import java.util.LinkedList;
import java.util.List;

public class MenuItem extends IMenuItem {
    private String name;
    private MenuItem parent;
    private List<MenuItem> children = new LinkedList<>();
    private Action action;

    public MenuItem(String name, MenuItem parent, Action action) {
        this.parent = parent;
        this.name = name;
        this.action = action;
        init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuItem getParent() {
        return this.parent;
    }

    public List<MenuItem> getChildren() {
        return children;
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
    public void doAction() {
    action.doAction();
    }

    @Override
    public void init() {
        if(this.parent != null) {
            this.name = parent.name.split(" ")[0]
                    .concat(".")
                    .concat(String.valueOf(parent.children.size() + 1)
                            .concat(" ")
                            .concat(name));
            this.parent.children.add(this);
        }
    }
}
