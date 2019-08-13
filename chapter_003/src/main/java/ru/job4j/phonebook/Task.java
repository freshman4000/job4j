package ru.job4j.phonebook;

/**
 * Class that creates Task.
 */
public class Task {
    private String desc;
    private int priority;

    /**
     * Constructor.
     * @param desc description.
     * @param priority priority of the task.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Getter for description.
     * @return description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter for priority.
     * @return priority number.
     */
    public int getPriority() {
        return priority;
    }
}