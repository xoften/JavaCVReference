package mj223gn_assign2;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-02-07.
 */
public interface Queue {

    /**
     * Returns the size of the queue.
     * @return size as int.
     */
    int size();                     // current queue size

    /**
     * Checks if the the queue is empty.
     * @return true if the list is empty or false if there is nodes in it.
     */
    boolean isEmpty();              // true if queue is empty

    /**
     * Adds an Object element to the queue.
     * @param element to add.
     */
    void enqueue(Object element);   // add element at end of queue

    /**
     * Removes the first element in the queue
     * @return the removed element.
     * @throws IndexOutOfBoundsException if queue is empty.
     */
    Object dequeue();               // return and remove first element.

    /**
     * Gets the first element in the queue and return it.
     * @return the first element in queue.
     * @throws IndexOutOfBoundsException if the queue is empty
     *
     */
    Object first();                 // return (without removing) first element

    /**
     * Gets the last element in queue and return it.
     * @return last element in queue.
     * @throws IndexOutOfBoundsException if the queue is empty.
     */
    Object last();                  // return (without removing) last element

    /**
     * Creates a String with all elements in queue and return it.
     * @return String of queue.
     */
    String toString();              // return a string representation of the queue content

    /**
     * Creates new object of the class iterator.
     * @return new iterator object.
     */
    Iterator iterator();            // element iterator

}

