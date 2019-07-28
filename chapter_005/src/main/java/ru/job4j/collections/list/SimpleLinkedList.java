package ru.job4j.collections.list;

import java.util.NoSuchElementException;

/**
 * Class - where Nodes are boxed.
 * @param <E> parameter type.
 */
public class SimpleLinkedList<E> {
    int size;
    Node<E> first;

    /**
     * Adds node to list on first position.
     * @param data node data.
     */
    public void add(E data) {
        Node<E> newLink = new Node<E>(data);
        newLink.next = this.first;
        this.first = newLink;
        size++;
    }

    /**
     * Deletes head node.
     * @return deleted Node data.
     */
    public E delete() {
        Node<E> buffer = this.first;
        this.first = this.first.next;
        size--;
        return buffer.data;
    }

    /**
     * Gets Node by index.
     * @param index of needed node.
     * @return data.
     */
    public E get(int index) {
        if (index > this.size) throw new NoSuchElementException();
        Node<E> result = this.first;
        for (int i =0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Returns size of linkedList.
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Inner static class that is used to create Node.
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
