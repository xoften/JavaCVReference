package mj223gn_assign2.ArrayQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Circular arrayQueue
 * Created by Michaels on 2016-02-14.
 */
public class ArrayQueue implements Queue {

    private int head;
    private int tail;
    private int size;
    private Object[] queue;

    /**
     * constructor
     */
    public ArrayQueue() {

        final int START_SIZE = 10;
        queue = new Object[START_SIZE];
        size = 0;
        head = 0;
        tail = 0;
    }

    /**
     * returns length on array
     * @return array length
     */
    public int getLength(){
        return queue.length;
    }

    /**
     * checks how many elements there is in the array
     * @return how many elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * check if the array is empty
     * @return true if empty else false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add an element to the tail of queue
     * @param element to add.
     */
    @Override
    public void enqueue(Object element) {
        //check if resizing is needed
        resize();
        size++;
        queue[tail] = element;
        tail = (tail + 1) % queue.length;
    }

    /**
     * remove the first object in queue
     * @return removed object
     */
    @Override
    public Object dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();
        Object dequeued = queue[head];
        head = (head + 1) % queue.length;
        size--;

        return dequeued;
    }

    /**
     * shows the first object in queue
     * @return first object
     */
    @Override
    public Object first() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head;
    }

    /**
     * shows the last object in queue
     * @return last object
     */
    @Override
    public Object last() {
        if (isEmpty())
            throw new NoSuchElementException();
        //we check so we dont get tail to -1
        if(tail == 0)
            return queue.length-1;
        return tail-1;
    }

    /**
     * iterates over the objects in queue
     * @return iterats over objects
     */
    @Override
    public Iterator iterator() {
        return new iterator();
    }

    public void resize() {
        if (size == queue.length) {
            Object[] temp = new Object[2 * queue.length];
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[(head + i) % queue.length];
            }
            queue = temp;
            head = 0;
            tail = size;
        }
    }

    /**
     * ToString method, returns array as a String
     * @return array as String
     */
    @Override
    public String toString(){
        String out = "|";
        if(isEmpty())
            return "Queue is empty!";
        else{
           for (int i = head; i != tail; i= (i+1)% queue.length){
               out += " " + queue[i] ;
            }
        }
        return out + " |";
    }
    private class iterator implements Iterator {

        private int next = head;
        private int count = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count < size;
        }

        /**
                * Returns the next element in the iteration.
        *
                * @return the next element in the iteration
        * @throws NullPointerException if the iteration has no more elements
        */
        @Override
        public Object next() {
            Object out = queue[next];
            next = (next +1) % queue.length;
            count++;
            return out;
        }
    }
}
