package mj223gn_assign4;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-03-04.
 */
public class LinkedQueue<T> implements Queue<T>{

    private int size;
    private Node head;
    private Node tail;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size() == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(T t) {
        if(isEmpty()){
            head = new Node(t);
            tail = head;
        }
        else{
            tail.next = new Node(t);
            tail = tail.next;
        }
        size++;
    }

    public T dequeue() {
        if(isEmpty()){
            throw new NullPointerException("Cant dequeue, queue is empty!");
        }
        else {
            T out = head.element;
            head = head.next;
            size--;
            return out;
        }
    }

    public T first() {
        if (this.isEmpty())
            throw new NullPointerException("Cant get first element: Queue is empty.");
        else {
            //returns head object without removing it
            return head.element;
        }
    }

    public T last() {
        //if we try to check a empty queue we get an error
        if (this.isEmpty())
            throw new NullPointerException("Cant get last element: Queue is empty.");
        else {
            //returns tail object without removing it
            return tail.element;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator itr = this.iterator();
            while(itr.hasNext()){
                sb.append(itr.next());
            }
        return sb.toString();
    }
    @Override
    public Iterator iterator() {
        return new iterator();
    }

    private class Node{
        private Node next;
        private T element;

        Node(T t){
            next = null;
            element = t;
        }
    }
    private class iterator implements Iterator {

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
