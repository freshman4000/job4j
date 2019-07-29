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
    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<E> getFirst() {
        return this.first;
    }
    public void setFirst(Node<E> node) {
        this.first = node;
    }
    /**
     * Creates iterator over the list.
     *
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int expectedModCount = modCount;
            private int position = 0;
            private Node<E> current = first;


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
                current = position++ == 0 ? current : current.getNext();
                return current.getData();
            }
        };
    }

    /**
     * Static inner class that is responsible for creating Nodes for this DynamicLinkedList.
     *
     * @param <E> type parameter.
     */
    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
