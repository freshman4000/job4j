package ru.job4j.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that uses Nodes to store data.
 *
 * @param <E> type parameter.
 */
public class DynamicLinkedList<E> implements Iterable {
    private int size;
    private int modCount;
    private Node<E> first;

    /**
     * Adds data to linked list.
     *
     * @param data to add.
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = this.first;
        this.first = newNode;
        size++;
        modCount++;
    }

    /**
     * Gets data from list by index of node.
     *
     * @param index of needed Node.
     * @return data stored in the Node.
     */
    public E get(int index) {
        if (index > this.size) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Creates iterator over the list.
     *
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            int expectedModCount = modCount;
            int position = 0;

            /**
             * Checks if iterator has more elements to iterate.
             * @return boolean value.
             */
            @Override
            public boolean hasNext() {
                return position < size;
            }

            /**
             * Returns next value of iterator.
             * @return next value.
             */
            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(position++);
            }
        };
    }

    /**
     * Static inner class that is responsible for creating Nodes for this DynamicLinkedList.
     *
     * @param <E> type parameter.
     */
    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
