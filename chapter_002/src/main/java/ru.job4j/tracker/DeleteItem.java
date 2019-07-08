package ru.job4j.tracker;
/**
 * Class that deletes Item from database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class DeleteItem implements UserAction {
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
    public DeleteItem(int key, String message) {
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
        System.out.println("------------ Item removal --------------");
        String id = input.ask("Type item id :");
        if (tracker.delete(id)) {
            System.out.println("Item was deleted :");
        } else {
            System.out.println("--- Item Id : " + id + " not found. Try different id ---");
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
