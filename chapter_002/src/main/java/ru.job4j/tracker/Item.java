package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Objects;
/**
 * Class Item represents the instance of order - the main data cell in database - items[].
 * @author Vit Efremov (freshman4000@gmail.com).
 * @since 05.07.2019.
 * @version 1.0.
 */
public class Item {
    /**
     * Name of order.
     */
    private String name;
    /**
     * Unique order identifier type String.
     */
    private String id;
    /**
     * Order description.
     */
    private String desc;
    /**
     * Time of order compilation.
     */
    private long time;
    /**
     * Constructor auto time.
     * @param name of order.
     * @param desc - description of order.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.time = System.currentTimeMillis();
    }
    /**
     * Constructor manual time.
     * @param name of order.
     * @param desc - description of order.
     * @param time - time of order compilation.
     */
    public Item(String name, String desc, long time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }
    /**
     * Getter.
     * @return name of order.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Setter.
     * Sets name of order.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter.
     * @return id of order.
     */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Getter.
     * @return description of order.
     */
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * Getter.
     * @return time of order compilation in milliseconds.
     */
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Method that specifies the way objects will be compared.
     * @param o - incoming object.
     * @return result of comparison.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(desc, item.desc);
    }
    /**
     * Method that returns the unique hash of the object
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        return String.format(
                "--- %s %s ---\r\n" + "--- %s %s ---\r\n" + "--- %s %s ---\r\n" + "--- %s %s ---\r\n",
                "Item ID :", this.getId(), "Item name :", this.getName(),
                "Item description :", this.getDesc(),
                "Time item added :", sdf.format(this.getTime()));
    }
}
