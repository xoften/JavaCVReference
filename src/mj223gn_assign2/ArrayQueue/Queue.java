package mj223gn_assign2.ArrayQueue;

import java.util.Iterator;

/**
 * Queue Interface
 * Created by Michaels on 2016-02-07.
 */
public interface Queue {

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
     * Adds an Object element to the end queue.
     * @param element to add.
     */
    void enqueue(Object element);

    /**
     * Return and removes the first element in the queue
     * @return the removed element
     * @throws IndexOutOfBoundsException if queue is empty
     */
    Object dequeue();

    /**
     * Return (without removing) first element in queue
     * @return the first element in queue
     * @throws IndexOutOfBoundsException if the queue is empty
     *
     */
    Object first();

    /**
     * Return (without removing) last element in queue
     * @return last element in queue
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    Object last();

    /**
     * Return a string representation of the queue content.
     * @return String of queue
     */
    String toString();

    /**
     * Element iterator.
     * @return Iterates over elements in queue
     */
    Iterator iterator();            // element iterator

}

