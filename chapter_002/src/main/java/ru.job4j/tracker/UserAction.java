package ru.job4j.tracker;

/**
 * Interface for user's action.
 */
public interface UserAction {
    /**
     * Returns key that user chose.
     * @return users choice.
     */
    int key();

    /**
     * Method that specifies input type and data.
     * @param input type.
     * @param tracker object.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Returns information about action.
     * @return
     */
    String info();
    }

