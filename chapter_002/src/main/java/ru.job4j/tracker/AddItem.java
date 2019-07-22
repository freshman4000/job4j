package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class AddItem extends BaseAction {
    /**
     * Constructor.
     * @param key of an action.
     * @param message of an action.
     */
    public AddItem(int key, String message) {
        super(key, message);
    }
    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name :");
        String desc = input.ask("Please, provide item description :");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("------------ New item with Id : " + item.getId() + "-----------");
        output.accept("------------ New item with name : " + item.getName() + "-----------");
        output.accept("------------ New item with description : " + item.getDesc() + "-----------");
    }
}

