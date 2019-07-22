package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class FindItemById extends BaseAction {
    /**
     * Constructor.
     * @param key of an action.
     * @param message of an action.
     */
    public FindItemById(int key, String message) {
        super(key, message);
    }
    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Items search --------------");
        String id = input.ask("Type item id :");
        if (tracker.findById(id) != null) {
            Item item = tracker.findById(id);
            output.accept(item.toString());
        } else {
            output.accept("--- Item Id : " + id + " not found. Specify different id ---");
        }
    }
}