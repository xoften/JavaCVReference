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
    public LinkedQueue(){
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
        if (this.isEmpty()) {
            head = new Node(element);
            tail = head;
        }
        else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public Object dequeue() {
        if(this.isEmpty())
            throw new NullPointerException("Cant dequeue element: Queue is empty.");
        Node first = head;
        head = head.next;
        size--;
        return first;
    }

    @Override
    public Object first() {
        if(this.isEmpty())
            throw new NullPointerException("Cant get first element: Queue is empty.");
        else {
            return head.object;
        }
    }

    @Override
    public Object last() {
        if(this.isEmpty())
            throw new NullPointerException("Cant get last element: Queue is empty.");
        else{
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
        if(this.isEmpty()){
            out = "The queue is empty";
            return out;
        }
        else {
            iterator it = new iterator();
            while (it.hasNext()) {
                out = out + it.next() + ", ";
            }
            return out.substring(0,out.length()-2) + " |";
        }
    }

    /**
     * Node private inner class
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
    private class iterator implements Iterator{

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


