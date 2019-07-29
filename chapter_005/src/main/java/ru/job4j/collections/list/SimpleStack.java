package ru.job4j.collections.list;

/**
 * Class container based on DynamicLinkedList with added methods poll and push.
 * @param <E> type parameter.
 */
public class SimpleStack<E> {
    private DynamicLinkedList<E> list = new DynamicLinkedList<>();

    /**
     * Retrieves the value and removes it from the head of the stack, if stack is empty
     * returns null.
     * @return removed value.
     */
    public E poll() {
        E result;
        if (list.size() < 1) {
            result = null;
        } else {
            result = this.list.removeFirst();
        }
        return result;
    }

    /**
     * Adds value to the head of the stack.
     * @param data that needs to be added.
     */
    public void push(E data) {
       list.add(data);
    }
}
