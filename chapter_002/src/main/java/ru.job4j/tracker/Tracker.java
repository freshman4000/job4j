package ru.job4j.tracker;

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
//    public boolean delete(String id, Item item) {}
//    public Item[] findAll(){}
//    public Item[] findByName(String key) {}
    public Item findById(String id) {
        Item item = null;
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                item = this.items[index];
                break;
            }
        }
        return item;
    }


}
