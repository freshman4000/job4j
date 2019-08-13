package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class TrackerSingleLazy {
 private static TrackerSingleLazy instance;
 private TrackerSingleLazy() { }
 public static TrackerSingleLazy getInstance() {
     if (instance == null) {
         instance = new TrackerSingleLazy();
     }
     return instance;
 }
    /**
     * Items array.
     */
    private Item[] items = new Item[100];
    /**
     * Order number of new item.
     */
    private int position = 0;
    /**
     * Method adds new item to database.
     * @param item new item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
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
     * Replaces item with given id in items[] by given item.
     * @param id of the item that needs to be replaces.
     * @param item - replacement.
     * @return if replacement took place.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Deletes item with given id from items[].
     * @param id of the item that needs to be deleted.
     * @return if replacement took place.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - 1 - index);
                items[items.length - 1] = null;
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Creates new array with all not null elements.
     * @return array.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Finds Items by name and puts it to array.
     * @param key - searched items name.
     * @return array of found objects type Item.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return count > 0 ? result : new Item[0];
    }
    /**
     * Finds Item by id.
     * @param id of searched item.
     * @return object type Item.
     */
    public Item findById(String id) {
        Item result = null;
        if (this.position != 0) {
            for (int index = 0; index != this.position; index++) {
                if (this.items[index] != null && this.items[index].getId().equals(id)) {
                    result = this.items[index];
                    break;
                }
            }
        }
        return result;
    }
}