package ru.job4j.tracker;
/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class ShowItems implements UserAction {
    /**
     * Key of action assigned to this class.
     */
    private int key;
    /**
     * Message of action assigned to this class that is shown in menu.
     */
    private String message;

    /**
     * Constructor.
     * @param key of an action.
     * @param message of an action.
     */
    public ShowItems(int key, String message) {
        this.key = key;
        this.message = key +". "+ message;
    }
    /**
     * Method that returns actions key.
     * @return
     */
    @Override
    public int key() {
        return key;
    }

    /**
     * Method that executes action.
     * @param input type.
     * @param tracker object.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Showing all items --------------");
        if (tracker.findAll().length != 0) {
            for (Item items : tracker.findAll()) {
                System.out.println(items.toString());
            }
        } else {
            System.out.println("--- List is empty. Try to add item. ---");
        }
    }
    /**
     * Method that shows info about action.
     * @return action message.
     */
    @Override
    public String info() {
        return message;
    }
}
