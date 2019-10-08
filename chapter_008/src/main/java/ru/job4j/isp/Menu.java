package ru.job4j.isp;

import java.util.List;

public class Menu implements AddItem, Show {
    private List<MenuItem> menuLIst;

    public Menu(List<MenuItem> menuLIst) {
        this.menuLIst = menuLIst;
    }

    @Override
    public void add(MenuItem root) {
        menuLIst.add(root);
    }

    @Override
    public void show() {
    for (MenuItem item : menuLIst) {
        item.show();
    }
    }
}
