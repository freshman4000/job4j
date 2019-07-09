package ru.job4j.tracker;
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
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Items search --------------");
        String id = input.ask("Type item id :");
        if (tracker.findById(id) != null) {
            Item item = tracker.findById(id);
            System.out.println(item.toString());
        } else {
            System.out.println("--- Item Id : " + id + " not found. Specify different id ---");
        }
    }
}