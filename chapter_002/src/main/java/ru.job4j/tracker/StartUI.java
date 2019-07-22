package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class StartUI Tracker app. entrance point which starts up user interface.
 */
public class StartUI {
    private Input input;
    private final Tracker tracker;
    private final Consumer<String> output;
    /**
     * Constructor.
     * @param tracker init database.
     * @param input interface of input.
     */
    public StartUI(Tracker tracker, Input input, Consumer<String> output) {
        this.tracker = tracker;
        this.input = input;
        this.output = output;
    }
    /**
     *Method init initialises UI and keeps track on users input.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }
    /**
     * Method main.
     * @param args - incoming array of args.
     */
    public static void main(String[] args) {
        new StartUI(new Tracker(), new ValidateInput(new ConsoleInput()), (str) -> System.out.println(str)).init();
    }
}



