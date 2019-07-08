package ru.job4j.tracker;

/**
 * Class StartUI Tracker app. entrance point which starts up user interface.
 */
public class StartUI {
    private Input input;
    private final Tracker tracker;
    /**
     * Constructor.
     * @param tracker init database.
     * @param input interface of input.
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }
    /**
     *Method init initialises UI and keeps track on users input.
     */
    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        do {
            menuTracker.show();
            menuTracker.select(Integer.valueOf(this.input.ask("Select:")));
        }
        while (!"y".equals(this.input.ask("Exit?(y)")));
    }
    /**
     * Method main.
     * @param args - incoming array of args.
     */
    public static void main(String[] args) {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }
}



