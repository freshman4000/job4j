package ru.job4j.tracker;
/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class ShowItems extends BaseAction {
    /**
     * Constructor.
     * @param key of an action.
     * @param message of an action.
     */
    public ShowItems(int key, String message) {
        super(key, message);
    }
    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Showing all items --------------");
        if (tracker.findAll().size() != 0) {
            for (Item items : tracker.findAll()) {
                System.out.println(items.toString());
            }
        } else {
            System.out.println("--- List is empty. Try to add item. ---");
        }
    }
}
