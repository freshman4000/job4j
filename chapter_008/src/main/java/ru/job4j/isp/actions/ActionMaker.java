package ru.job4j.isp.actions;

public class ActionMaker {
    private Action action;

    public ActionMaker(Action action) {
        this.action = action;
    }
    public void makeAction() {
        action.doAction();
    }
}
