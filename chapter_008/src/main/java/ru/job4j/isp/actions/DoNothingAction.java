package ru.job4j.isp.actions;

/**
 * Bulk action class.
 */
public class DoNothingAction implements Action {
    @Override
    public void doAction() {
        System.out.println("This is not leaf menu item");
    }
}
