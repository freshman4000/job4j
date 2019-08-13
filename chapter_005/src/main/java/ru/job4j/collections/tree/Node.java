package ru.job4j.collections.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<E extends Comparable<E>> {
    private final E value;
    private List<Node<E>> children = new ArrayList<>();

    public Node(final E value) {

        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;

        return Objects.equals(this.value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Value = " + value;
    }
}
