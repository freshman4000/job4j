package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class UpdateItem extends BaseAction {
    /**
     * Constructor.
     * @param key of an action.
     * @param message of an action.
     */
    public UpdateItem(int key, String message) {
        super(key, message);
    }
    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Item update --------------");
        String id = input.ask("Type item id :");
        String name = input.ask("Update name :");
        String desc = input.ask("Update description :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            item.setId(id);
            output.accept("------------ Item Id : " + item.getId() + "was updated -----------");
        } else {
            output.accept("--- Item Id : " + id + " not found. Try different id ---");
        }
    }
}