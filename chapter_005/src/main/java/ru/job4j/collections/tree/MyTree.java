package ru.job4j.collections.tree;

import java.util.*;

public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int conMod = 0;

    public MyTree(E value) {
        this.root = new Node<E>(value);
    }

    /**
     * Creates new Iterator based on list of all elements in tree created by
     * by Breadth First Search.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> cur = new LinkedList<>();
        cur.offer(root);
        return new Iterator<E>() {
            private int conModItr = conMod;


            @Override
            public boolean hasNext() {
                return !cur.isEmpty();
            }

            @Override
            public E next() {
                if (conMod != conModItr) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> node = cur.poll();
                if (cur.isEmpty()) {
                    if (!node.leaves().isEmpty()) {
                        for (Node<E> n : node.leaves()) {
                            cur.offer(n);
                        }
                    }
                }
                return node.getValue();
            }
        };
    }

    /**
     * Method checks if all nodes in tree have less then 3 children.
     *
     * @return boolean result of inspection.
     */
    public boolean isBinary() {
        Iterator<E> it = this.iterator();
        boolean result = true;
        while (it.hasNext()) {
            Optional<Node<E>> current = this.findBy(it.next());
            if (current.isPresent()) {
                if (current.get().leaves().size() > 2) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Method checks if parent Node exists. If so, checks if this nodes leaves don't
     * have Nodes with same value. If true - adds new Node to the parent's node List
     * of children.
     *
     * @param parent value of parent node to which child node to be added.
     * @param child  value of child node which needs to be added to parent.
     * @return boolean result of addition.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> neededParent = findBy(parent);
            neededParent.ifPresent(eNode -> eNode.add(new Node<E>(child)));
            result = true;
        }
        conMod = result ? conMod + 1 : conMod;
        return result;
    }

    /**
     * Finds Node in tree by value.
     *
     * @param value value of needed Node.
     * @return result of search of Optional type.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                result = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }
}
