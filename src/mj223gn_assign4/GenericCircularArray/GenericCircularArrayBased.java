package mj223gn_assign4.GenericCircularArray;

import mj223gn_assign4.GenericLinkedQueue.Queue;

import java.util.Iterator;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-08.
 */
public class GenericCircularArrayBased<T> implements Queue<T>{
    private int head;
    private int tail;
    private int size;
    private Object[] queue;

    /**
     * constructor
     */
    public GenericCircularArrayBased() {

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
     * @param t to add.
     */
    @Override
    public void enqueue(T t) {
        //check if resizing is needed
        resize();
        size++;
        queue[tail] = t;
        tail = (tail + 1) % queue.length;
    }

    /**
     * remove the first object in queue
     * @return removed object
     */
    @Override
    public T dequeue() {
        if(isEmpty())
            throw new NullPointerException();
        T dequeued = (T) queue[head];
        head = (head + 1) % queue.length;
        size--;

        return dequeued;
    }

    /**
     * shows the first object in queue
     * @return first object
     */
    @Override
    public T first() {
        if (isEmpty())
            throw new NullPointerException();
        return (T) queue[head];
    }

    /**
     * shows the last object in queue
     * @return last object
     */
    @Override
    public T last() {
        if (isEmpty())
            throw new NullPointerException();
        //we check so we dont get tail to -1
        if(tail == 0)
            return (T) queue[queue.length-1];
        return (T) queue[tail-1];
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
        String out = "[";
        if(isEmpty())
            return "Queue is empty!";
        else{
            Iterator<T> itr = this.iterator();
            while (itr.hasNext()){
                out += itr.next() + ", ";
            }
        }
        return out.substring(0, out.length()-2) + "]";
    }
    private class iterator implements Iterator<T> {

        private int next = head;
        private int count = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count < size;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NullPointerException if the iteration has no more elements
         */
        @Override
        public T next() {
            if(isEmpty()){
                throw new NullPointerException();
            }
            T out = (T) queue[next];
            next = (next +1) % queue.length;
            count++;
            return out;
        }
    }
}
