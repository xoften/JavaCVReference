package mj223gn_assign2.LinkedQueue;

import java.util.Iterator;

/**
 * LinkedQueue class with methods from our queue interface
 * Created by Michaels on 2016-02-07.
 */
public class LinkedQueue implements Queue {

    private int size;
    private Node head;
    private Node tail;

    /**
     * Constructor for our linkedQueue.
     */
    public LinkedQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object element) {
        //if Queue is empty set new node to head and tail
        if (this.isEmpty()) {
            head = new Node(element);
            tail = head;
        }
        //if there is nodes in queue we set tails next to new node
        else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        //if we try to dequeue a empty queue we get an error
        if (this.isEmpty())
            throw new NullPointerException("Cant dequeue element: Queue is empty.");
        //if there is nodes we se set a temp Node to head, then we set head to heads next. size - 1 and return temp.
        Node first = head;
        head = head.next;
        size--;
        return first;
    }

    @Override
    public Object first() {
        //if we try to check a empty queue we get an error
        if (this.isEmpty())
            throw new NullPointerException("Cant get first element: Queue is empty.");
        else {
            //returns head object without removing it
            return head.object;
        }
    }

    @Override
    public Object last() {
        //if we try to check a empty queue we get an error
        if (this.isEmpty())
            throw new NullPointerException("Cant get last element: Queue is empty.");
        else {
            //returns tail object without removing it
            return tail.object;
        }

    }

    @Override
    public Iterator iterator() {
        return new iterator();
    }

    @Override
    public String toString() {
        String out = "| ";
        if (this.isEmpty()) {
            out = "The queue is empty";
            return out;
        } else {
            iterator it = new iterator();
            while (it.hasNext()) {
                out = out + it.next() + ", ";
            }
            return out.substring(0, out.length() - 2) + " |";
        }
    }

    /**
     * Node private inner class
     * Creates a new node and adding the object
     */
    private class Node {
        Object object;
        Node next = null;

        Node(Object obj) {
            object = obj;
        }
    }

    /**
     * iterator inner class
     */
    private class iterator implements Iterator {

        Node nodes = head;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return nodes != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NullPointerException if the iteration has no more elements
         */
        @Override
        public Object next() {
            Object ob = nodes.object;
            nodes = nodes.next;
            return ob;
        }


    }


}


