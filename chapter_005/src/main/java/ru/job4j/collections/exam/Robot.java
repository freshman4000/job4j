package ru.job4j.collections.exam;

import java.util.*;

/**
 * Class which can calculate the cheapest path of robot moving in 2d array, according to cell values.
 * It is assumed that robot can move up, right, forward. In order to calculate paths where robot can move any
 * direction, we would need to add to getAllChildren() method - 5 lines, where Node in cell with coordinates x,
 * y - 1 will be added as a child to "this" node.
 */
public class Robot {
    int[][] array;
    Map<String, Node> nodes = new TreeMap<>();

    public Robot(int[][] array) {
        this.array = array;
        for (int i = 0; i != array.length; i++) {
            for (int j = 0; j != array[i].length; j++) {
                Node node = new Node(i, j);
                node.value = array[node.x][node.y];
                nodes.put(node.x + "" + node.y, node);
            }
        }
        nodes.forEach((x, y) -> getAllChildren(y, array));
    }

    /**
     * Assigns all children to specified node.
     *
     * @param node  whose children need to be assigned.
     * @param array given 2d array.
     */
    private void getAllChildren(Node node, int[][] array) {
        if (node.x > 0) {
            int childX = node.x - 1;
            int childY = node.y;
            node.children.add(nodes.get(childX + "" + childY));
        }
        if (node.y < array[node.x].length - 1) {
            int childX = node.x;
            int childY = node.y + 1;
            node.children.add(nodes.get(childX + "" + childY));
        }
        if (node.x < array.length - 1) {
            int childX = node.x + 1;
            int childY = node.y;
            node.children.add(nodes.get(childX + "" + childY));
        }
    }

    /**
     * Getter for node.
     *
     * @param x coordinate.
     * @param y coordinate.
     * @return node with specified coordinates.
     */
    public Node getNode(int x, int y) {
        return nodes.get(x + "" + y);
    }

    /**
     * Method that calculates the cheapest path.
     *
     * @param rootX starting Point x coordinate.
     * @param rootY starting Point y coordinate.
     * @param endX  ending Point x coordinate.
     * @param endY  ending Point y coordinate.
     * @return array of values of Nodes from start to end of the cheapest path.
     */
    public int[] getBestPath(int rootX, int rootY, int endX, int endY) {
        Node cur = getNode(rootX, rootY);
        cur.weight = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.add(cur);
        while (!q.isEmpty()) {
            Node rrr = q.poll();
            rrr.settled = true;
            assignWeights(rrr);
            for (Node node : rrr.children) {
                if (!node.settled) {
                    q.add(node);
                }
            }
        }
        Node end = nodes.get(endX + "" + endY);
        LinkedList<Integer> lst = new LinkedList<>();
        while (end != null) {
            lst.offerFirst(end.value);
            end = end.predecessor;
        }
        int[] result = new int[lst.size()];
        int n = -1;
        for (Integer i : lst) {
            result[++n] = i;
        }
        return result;
    }

    /**
     * Method that assigns cheapest weights to all children of specified node.
     *
     * @param node to whose children cheapest weights need to be assigned.
     */
    public void assignWeights(Node node) {
        for (Node current : node.children) {
            if (node.weight + current.value < current.weight) {
                current.weight = node.weight + current.value;
                current.predecessor = node;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int weight;
        int value;
        List<Node> children;
        Node predecessor;
        int x;
        int y;
        boolean settled;

        public Node(int x, int y) {
            this.weight = Integer.MAX_VALUE;
            this.value = 0;
            this.children = new ArrayList<>();
            this.predecessor = null;
            this.x = x;
            this.y = y;
            this.settled = false;
        }

        /**
         * Utility method, overrided for testing purposes.
         *
         * @return needed output string format.
         */
        public String toString() {
            return String.format("Node V=%s W=%s (Pre=%s) [%s,%s]" + System.lineSeparator(),
                    value, weight, predecessor, x, y);
        }

        /**
         * Method to specify order of Nodes in priority queue.
         *
         * @param o node for comparison.
         * @return int value.
         */
        @Override
        public int compareTo(Node o) {
            int res = this.weight - o.weight;
            return res == 0 ? (this.x + "" + this.y).compareTo(o.x + "" + o.y) : res;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value
                    && x == node.x
                    && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, x, y);
        }
    }
}
