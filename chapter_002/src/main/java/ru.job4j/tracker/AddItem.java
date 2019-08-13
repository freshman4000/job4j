package ru.job4j.tracker;

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
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name :");
        String desc = input.ask("Please, provide item description :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New item with Id : " + item.getId() + "-----------");
        System.out.println("------------ New item with name : " + item.getName() + "-----------");
        System.out.println("------------ New item with description : " + item.getDesc() + "-----------");
    }
}

