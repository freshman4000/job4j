package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * массив для хранения заявок.
     */
    private Item[] items = new Item[100];
    /**
    * Указатель ячейки для новой заявки.
    */
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
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
        for (int index = 0; index < this.items.length; index++) {
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
        for (int index = 0; index < this.items.length; index++) {
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
    public Item[] findAll(){
        Item[] result = this.items;
        int count = 0;
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] == null && index != items.length - 1 - count) {
                count++;
                System.arraycopy(items, index + 1, items, index, items.length - 1 - index);
                items[items.length - 1 - count] = null;
            }
        }
        result = Arrays.copyOf(result, 100 - count - 1);
        return result;
    }
    /**
     * Finds Items by name and puts it to array.
     * @param key - searched items name.
     * @return array of found objects type Item.
     */
    public Item[] findByName(String key) {
    Item[] result = new Item[100];
    int position = 0;
        for (Item item : this.items) {
        if (item != null && item.getName().equals(key)) {
            result[position++] = item;
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
