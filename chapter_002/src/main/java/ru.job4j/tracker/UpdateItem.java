package ru.job4j.tracker;
/**
 * Class that creates Item and adds it to database.
 * @author Vit Efremov (freshman4000@gmail.com).
 * @version 1.0.
 * @since 08.07.2019.
 */
public class UpdateItem implements UserAction {
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
    public UpdateItem(int key, String message) {
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
    /**
     * Method that shows info about action.
     * @return action message.
     */
    @Override
    public String info() {
        return message;
    }
}