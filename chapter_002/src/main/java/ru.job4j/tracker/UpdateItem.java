package ru.job4j.tracker;
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
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Item update --------------");
        String id = input.ask("Type item id :");
        String name = input.ask("Update name :");
        String desc = input.ask("Update description :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            item.setId(id);
            System.out.println("------------ Item Id : " + item.getId() + "was updated -----------");
        } else {
            System.out.println("--- Item Id : " + id + " not found. Try different id ---");
        }
    }
}