package ru.job4j.tracker;
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
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Item removal --------------");
        String id = input.ask("Type item id :");
        if (tracker.delete(id)) {
            System.out.println("Item was deleted :");
        } else {
            System.out.println("--- Item Id : " + id + " not found. Try different id ---");
        }
    }
}
