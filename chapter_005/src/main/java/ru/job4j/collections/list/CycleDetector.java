package ru.job4j.collections.list;

import ru.job4j.collections.list.DynamicLinkedList.*;

/**
 * Class that has static method which figers out if Node list is cyclic.
 */
public class CycleDetector {
    static boolean hasCycle(Node<?> first) {
        boolean result = false;
        if (first != null) {
            Node<?> fast = first.getNext().getNext();
            Node<?> slow = first.getNext();

            while (fast != null && slow != null) {

                if (fast.equals(slow)) {
                    result = true;
                    break;
                }
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
        }
        return result;
    }
}
