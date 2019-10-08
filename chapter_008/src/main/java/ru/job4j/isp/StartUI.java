package ru.job4j.isp;

import ru.job4j.isp.actions.*;
import ru.job4j.isp.inputs.Input;
import ru.job4j.isp.inputs.UserInput;

import java.util.ArrayList;

public class StartUI {
    private Menu menu;
    private Input input;

    public StartUI(Menu menu, Input input) {
        this.menu = menu;
        this.input = input;
    }

    public void start() {
        System.out.println("Choose action or type \"exit\":");
        menu.show();
        while (true) {
            String answer = input.getInput();
            if ("exit".equals(answer)) {
                break;
            }
            switch (answer) {
                case "2.1":
                    new ActionMaker(new Action21()).makeAction();
                    break;
                case "2.2":
                    new ActionMaker(new Action22()).makeAction();
                    break;
                case "2.3":
                    new ActionMaker(new Action23()).makeAction();
                    break;
                case "1.1.1":
                    new ActionMaker(new Action111()).makeAction();
                    break;
                case "1.1.2":
                    new ActionMaker(new Action112()).makeAction();
                    break;
                case "1.2.1":
                    new ActionMaker(new Action121()).makeAction();
                    break;
                case "1.2.2":
                    new ActionMaker(new Action122()).makeAction();
                    break;
                default:
                    System.out.println("no such action");
            }
        }
    }
}
