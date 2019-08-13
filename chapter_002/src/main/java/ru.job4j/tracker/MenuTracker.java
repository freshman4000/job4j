package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MenuTracker that creates menu and suggests it to user.
 */
public class MenuTracker {
    /**
     * Specifies input type.
     */
    private Input input;
    /**
     * Specifies tracker.
     */
    private Tracker tracker;
    /**
     * List of saved actions.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Constructor.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method return actions menu list size.
     * @return number of actions.
     */
    public int getActionsLength() {
        return this.actions.size();
    }
    /**
     * Method that fills menu list.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    /**
     * Executes action, specified by key.
     *
     * @param key key of action.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Shows menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
