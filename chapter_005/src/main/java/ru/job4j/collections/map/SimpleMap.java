package ru.job4j.collections.map;

import java.util.*;

public class SimpleMap<K, V> implements Iterable {
    private int indexWhole;
    private int defCapas;
    private Node<K, V>[] array;
    private boolean hasNull = false;
    private float load = .75f;
    private int modControl = 0;

    public SimpleMap() {
        this.defCapas = 16;
        this.array = (Node<K, V>[]) new Node[defCapas];
        this.indexWhole = 0;
    }

    public SimpleMap(int size) {
        defCapas = size % 16 > 0 ? (size / 16 + 1) * 16 : size;
        this.array = (Node<K, V>[]) new Node[defCapas];
        this.indexWhole = 0;
    }

    private void controlCapacity() {
        if ((float) indexWhole / (float) array.length > load) {
            Node<K, V>[] buffer = array;
            defCapas *= 2;
            array = (Node<K, V>[]) new Node[defCapas];
            for (int i = 0; i != buffer.length; i++) {
                this.insert(buffer[i].key, buffer[i].value);
            }
        }
    }

    private int keyHash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private int bucketIndex(int keyhash) {
        return keyhash & (defCapas - 1);
    }

    private boolean checkNodesInBucket(int bucketKey, Node<K, V> pretender) {
        boolean result;

        if (array[bucketKey] == null) {
            result = pretender.key != null || !hasNull;
            hasNull = pretender.key == null && result;
        } else {
            if (pretender.key == null) {
                result = !hasNull;
            } else {
                result = true;
                Node<K, V> current = array[bucketKey];
                do {
                    if (pretender.key.equals(current.key)) {
                        result = false;
                        break;
                    }
                    current = current.next;
                } while (current != null);
            }
        }
        return result;
    }

    public boolean insert(K key, V value) {
        boolean result;
        int bucketIndex = bucketIndex(keyHash(key));
        int keyHashCode = keyHash(key);
        Node<K, V> pretender = new Node<>(keyHashCode, key, value, null);
        if (array[bucketIndex] == null && checkNodesInBucket(bucketIndex, pretender)) {
            array[bucketIndex] = pretender;
            result = true;
        } else if (array[bucketIndex] != null && checkNodesInBucket(bucketIndex, pretender)) {
            Node<K, V> buffer = array[bucketIndex];
            buffer.next = null;
            array[bucketIndex] = pretender;
            pretender.next = buffer;
            result = true;
        } else {
            result = false;
        }
        controlCapacity();
        modControl = result ? modControl + 1 : modControl;
        indexWhole = result ? indexWhole + 1 : indexWhole;
        return result;
    }

    public V get(K key) {
        V result;
        if (array[bucketIndex(keyHash(key))] == null) {
            result = null;
        } else {
            result = getNode(key).value;
        }
        return result;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> result = null;
        Node<K, V> current = array[bucketIndex(keyHash(key))];
        if (current != null) {
            if (key == null) {
                while (current != null) {
                    if (current.key == null) {
                        result = current;
                        break;
                    }
                    current = current.next;
                }
            } else {
                while (current != null) {
                    if (current.key.equals(key)) {
                        result = current;
                        break;
                    }
                    current = current.next;
                }
            }
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result;
        int index = bucketIndex(keyHash(key));
        if (array[index] == null) {
            result = false;
        } else {
            Node<K, V> current = array[index];
            if (key == null) {
                if (current.key == null) {
                    array[index] = current.next;
                    result = true;
                } else {
                    result = false;
                    while (current.next != null) {
                        if (current.next.key == null) {
                            current.next = current.next.next;
                            result = true;
                            break;
                        }
                        current = current.next;
                    }
                }
            } else {
                if (current.key.equals(key)) {
                    array[index] = current.next;
                    result = true;
                } else {
                    result = false;
                    while (current.next != null) {
                        if (current.next.key.equals(key)) {
                            current.next = current.next.next;
                            result = true;
                        }
                        current = current.next;
                    }
                }
            }
        }
        modControl = result ? modControl + 1 : modControl;
        indexWhole = result ? indexWhole - 1 : indexWhole;
        return result;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Node<K, V>>() {
            private int position = -1;
            private int concModControl = modControl;

            @Override
            public boolean hasNext() {
                return position < indexWhole - 1;
            }

            @Override
            public Node<K, V> next() {
                if (concModControl != modControl) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<K, V> result = null;
                ++position;
                int counter = -1;
                for (int i = 0; i != indexWhole; i++) {
                    if (array[i] != null) {
                        Node<K, V> current = array[i];
                        counter++;
                        while (counter != position) {
                            current = current.next;
                            if (current != null) {
                                counter++;
                            } else {
                                break;
                            }
                        }
                        if (counter == position) {
                            result = current;
                            break;
                        }
                    }
                }
                return result;
            }
        };
    }

    public class Node<K, V> {
        private int hashCode;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(int hashCode, K key, V value, Node<K, V> next) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
