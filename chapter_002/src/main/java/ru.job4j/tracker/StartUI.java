package ru.job4j.tracker;

/**
 * Class StartUI Tracker app. entrance point which starts up user interface.
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDI = "4";
    private static final String FINDN = "5";
    private static final String EXIT = "6";
    private Input input;
    private final Tracker tracker;
    /**
     * Constructor.
     * @param tracker init database.
     * @param input interface of input.
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }
    /**
     * Shows user menu in cycle.
     */
    private void showMenu() {
        System.out.println("0. Add new Item\r\n"
                + "1. Show all items\r\n"
                + "2. Edit item\r\n"
                + "3. Delete item\r\n"
                + "4. Find item by Id\r\n"
                + "5. Find items by name\r\n"
                + "6. Exit Program\r\n"
                + "Select:\r\n");
    }
    /**
     *Method init initialises UI and keeps track on users input.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = input.ask("Choose menu number: ");
            switch (answer) {
                case ADD : this.createItem();
                            break;
                case DELETE : this.deleteItem();
                            break;
                case SHOW : this.showItems();
                            break;
                case EDIT : this.editItem();
                            break;
                case FINDI : this.findById();
                            break;
                case FINDN : this.findByName();
                            break;
                case EXIT : exit = true;
                            break;
                            default:
            }
        }
    }
    /**
     * Adds item to database.
     */
    private void createItem() {
        System.out.println("------------ New item addition --------------");
        String name = this.input.ask("Type name :");
        String desc = this.input.ask("Type description :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New item with Id : " + item.getId() + "-----------");
    }
    /**
     * Removes item from database.
     */
    private void deleteItem() {
        System.out.println("------------ Item removal --------------");
        String id = input.ask("Type item id :");
        if (this.tracker.delete(id)) {
            System.out.println("Item was deleted :");
            } else {
            System.out.println("--- Item Id : " + id + " not found. Try different id ---");
        }
    }
    /**
     * Shows not null items from database.
     */
    private void showItems() {
        System.out.println("------------ Showing all items --------------");
        if (this.tracker.findAll().length != 0) {
            for (Item items : this.tracker.findAll()) {
                System.out.println(items.toString());
            }
        } else {
            System.out.println("--- List is empty. Try to add item. ---");
        }
    }
    /**
     * Edits and changes item data in database.
     */
    private void editItem() {
            System.out.println("------------ Item update --------------");
            String id = this.input.ask("Type item id :");
            String name = this.input.ask("Update name :");
            String desc = this.input.ask("Update description :");
            Item item = new Item(name, desc);
            if (this.tracker.replace(id, item)) {
                item.setId(id);
                System.out.println("------------ Item Id : " + item.getId() + "was updated -----------");
            } else {
                System.out.println("--- Item Id : " + id + " not found. Try different id ---");
            }
        }
    /**
     * Finds item in database by id.
     */
    private void findById() {
        System.out.println("------------ Items search --------------");
        String id = input.ask("Type item id :");
        if (this.tracker.findById(id) != null) {
            Item item = this.tracker.findById(id);
            System.out.println(item.toString());
            } else {
            System.out.println("--- Item Id : " + id + " not found. Specify different id ---");
        }
    }
    /**
     * Finds items in database by name.
     */
    private void findByName() {
        System.out.println("------------ Show all items with given name --------------");
        String name = input.ask("Type item name :");
        if (this.tracker.findByName(name).length != 0) {
            for (Item items : this.tracker.findByName(name)) {
               if (items != null) {
                   System.out.println(items.toString());
               }
            }
        } else {
            System.out.println("--- List is empty. Try to add new item ---");
        }
    }
    /**
     * Method main.
     * @param args - incoming array of args.
     */
    public static void main(String[] args) {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }
}



