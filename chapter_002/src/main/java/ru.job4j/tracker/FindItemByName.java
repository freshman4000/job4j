package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class FindItemByName extends BaseAction {
    /**
     * Constructor.
     * @param key of an action.
     * @param message of an action.
     */
    public FindItemByName(int key, String message) {
        super(key, message);
    }
    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Show all items with given name --------------");
        String name = input.ask("Type item name :");
        if (tracker.findByName(name).size() != 0) {
            for (Item items : tracker.findByName(name)) {
                if (items != null) {
                    output.accept(items.toString());
                }
            }
        } else {
            output.accept("--- List is empty. Try to add new item ---");
        }
    }
}