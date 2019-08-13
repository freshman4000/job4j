package ru.job4j.phonebook;

import java.util.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        ListIterator<Task> li = tasks.listIterator();
        while (li.hasNext()) {
            if (li.next().getPriority() > task.getPriority()) {
                index = li.previousIndex();
            }
        }
        tasks.add(index, task);
    }

    /**
     * Takes task from the head of the list and removes it;
     *
     * @return task from the head of the list. If list is empty - returns null.
     */
    public Task take() {
        return this.tasks.poll();
    }
}