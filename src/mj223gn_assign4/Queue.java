package mj223gn_assign4;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-03-04.
 */
public interface Queue<T> {

    /**
     * Current queue size
     * @return size as int
     */
    int size();

    /**
     * Checks if the the queue is empty
     * @return true if the list is empty
     */
    boolean isEmpty();

    /**
     * Adding an element to the queue
     * @param t element to add
     */
    void enqueue(T t);

    /**
     * Return and removes the first element in the queue
     * @return the removed element
     * @throws IndexOutOfBoundsException if queue is empty
     */
    T dequeue();

    /**
     * Return (without removing) first element in queue
     * @return the first element in queue
     * @throws IndexOutOfBoundsException if the queue is empty
     *
     */
    T first();

    /**
     * Return (without removing) last element in queue
     * @return last element in queue
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    T last();

    /**
     * Return a string representation of the queue content.
     * @return String of queue
     */
    String toString();

    /**
     * Element iterator.
     * @return Iterates over elements in queue
     */
    Iterator iterator();

}
