package mj223gn_assign4;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-03-04.
 */
public class LinkedQueue<T> implements Queue<T> {

    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T t) {
        //if Queue is empty set new node to head and tail
        if (isEmpty()) {
            head = new Node(t);
            tail = head;
        }
        //else set new node to tails next
        else{
            tail.next = new Node(t);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        //if empty throw exception
        if (isEmpty()) {
            throw new NullPointerException("Cant dequeue, queue is empty!");
        }
        //else remove and return first element in queue.
        else {
            T out = head.element;
            head = head.next;
            size--;
            return out;
        }
    }

    public T first() {
        //if empty throw exception
        if (this.isEmpty())
            throw new NullPointerException("Cant get first element: Queue is empty.");
        else {
            //returns head object without removing it
            return head.element;
        }
    }

    public T last() {
        //if empty throw exception
        if (this.isEmpty())
            throw new NullPointerException("Cant get last element: Queue is empty.");
        else {
            //returns tail element without removing it
            return tail.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //if empty we return a message
        if (isEmpty()) {
            return "Queue is empty!";
        }
        //else we use a iterator to add each element to the stringbuilder
        else {
            sb.append("[");
            Iterator itr = this.iterator();
            while (itr.hasNext()) {
                sb.append(itr.next());
                sb.append(", ");
            }
            //return the stringbuilder as a string, removing the 2 last chars
            return sb.toString().substring(0, sb.length() - 2) + "]";
        }
    }

    @Override
    public Iterator iterator() {
        return new iterator();
    }

    /**
     * inner Node class
     */
    private class Node {
        private Node next;
        private T element;

        Node(T t) {
            next = null;
            element = t;
        }
    }
    /**
     * iterator inner class
     */
    private class iterator implements Iterator<T> {

        Node nodes = head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return nodes != null;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * @throws NullPointerException if the iteration has no more elements
         */
        @Override
        public T next() {
            T t = nodes.element;
            nodes = nodes.next;
            return t;
        }


    }
}
