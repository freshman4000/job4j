package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Items array.
     */
    private ArrayList<Item> items = new ArrayList<>();
    /**
     * Method adds new item to database.
     * @param item new item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    /**
     * Method that generates unique id for item..
     * As well as item doesn't have unique fields, name and description, we need unique key for identification.
     * @return Unique key.
     */
    private String generateId() {
        Random random = new Random();
        return String.valueOf(System.currentTimeMillis() + random.nextInt(100));
    }

    /**
     * Replaces item with given id in items by given item.
     * @param id of the item that needs to be replaces.
     * @param item - replacement.
     * @return if replacement took place.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item item1 : this.items) {
            if (item1 != null && item1.getId().equals(id)) {
                items.set(items.indexOf(item1), item);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Deletes item with given id from items.
     * @param id of the item that needs to be deleted.
     * @return if replacement took place.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                this.items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Creates list of all not null elements.
     * @return array.
     */
    public ArrayList<Item> findAll() {
        return this.items;
            }
    /**
     * Finds Items by name and puts it to array.
     * @param key - searched items name.
     * @return array of found objects type Item.
     */
    public ArrayList<Item> findByName(String key) {
    ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
        if (item.getName().equals(key)) {
            result.add(item);
        }
    }
        return result;
}
    /**
     * Finds Item by id.
     * @param id of searched item.
     * @return object type Item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
                if (item != null && item.getId().equals(id)) {
                    result = item;
                    break;
                }
            }
        return result;
    }
}
