package ru.job4j.phonebook;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        int index = 0;
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for (Task t : tasks) {
                if (task.getPriority() < t.getPriority()) {
                    index = tasks.indexOf(t);
                    break;
                }
            }
            tasks.add(index, task);
        }
    }

    /**
     * Takes task from the head of the list and removes it;
     * @return task from the head of the list. If list is empty - returns null.
     */
    public Task take() {
        return this.tasks.poll();
    }
}