package ru.job4j.collections.list;

/**
 * Class that creates simple Queue with IO structure called FIFO.
 *
 * @param <E> type parameter.
 */
public class SimpleQueue<E> {
    private SimpleStack<E> stackIN;
    private SimpleStack<E> stackOUT;

    /**
     * SimpleQueue constructor.
     */
    public SimpleQueue() {
        this.stackIN = new SimpleStack<>();
        this.stackOUT = new SimpleStack<>();
    }

    /**
     * Method that checks if both stacks have elements. It polls elements from stackOUT till it gets empty.
     * If stackOUT is empty, all elements from stackIN have to be polled and pushed to stackOUT, till stackIN
     * gets empty. After that element from stackOUT can be polled. In case both stacks are empty, null value
     * will be returned.
     *
     * @return null, or element data.
     */
    public E poll() {
        E result;
        if (stackIN.isEmpty() && stackOUT.isEmpty()) {
            result = null;
        } else if (stackOUT.isEmpty() && !stackIN.isEmpty()) {
            while (!stackIN.isEmpty()) {
                stackOUT.push(stackIN.poll());
            }
            result = stackOUT.poll();
        } else {
            result = stackOUT.poll();
        }
        return result;
    }

    /**
     * Method that pushes value to stackIN.
     *
     * @param value incoming argument.
     */
    public void push(E value) {
        stackIN.push(value);
    }
}
