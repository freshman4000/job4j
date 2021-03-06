package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class that deletes Item from database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String message) {
        super(key, message);
    }
    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Item removal --------------");
        String id = input.ask("Type item id :");
        if (tracker.delete(id)) {
            output.accept("Item was deleted :");
        } else {
            output.accept("--- Item Id : " + id + " not found. Try different id ---");
        }
    }
}
