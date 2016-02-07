package mj223gn_assign2;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-02-07.
 */
public interface Queue {

    public int size();                     // current queue size
    public boolean isEmpty();              // true if queue is empty
    public void enqueue(Object element);   // add element at end of queue
    public Object dequeue();               // return and remove first element.
    public Object first();                 // return (without removing) first element
    public Object last();                  // return (without removing) last element
    public String toString();              // return a string representation of the queue content
    public Iterator iterator();            // element iterator

}

