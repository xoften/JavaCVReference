package mj223gn_assign2;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-02-07.
 */
public class LinkedQueue implements Queue {

    private int size;
    private Node head;
    private Node tail;

    /**
     * Constructor for our linkedlist.
     */
    public LinkedQueue(){
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Returns the size of the linkedlist.
     * @return size as int.
     */
   @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the the linkedlist is empty.
     * @return true if the list is empty or false if there is nodes in it.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an Object element to the linkedlist.
     * @param element to add.
     */
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
            throw new IndexOutOfBoundsException("Cant dequeue element: Queue is empty.");
        Node first = head;
        head = head.next;
        size--;
        return first;
    }

    @Override
    public Object first() {
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("Cant get first element: Queue is empty.");
        else {
            return head.object;
        }
    }

    @Override
    public Object last() {
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("Cant get last element: Queue is empty.");
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
        String out = "";
        if(this.isEmpty()){
            out = "The queue is empty";
            return out;
        }
        else {
            iterator it = new iterator();
            while (it.hasNext()) {
                out = out + it.next() + " ";
            }
            return out;
        }
    }

    private class Node {
        Object object;
        Node next = null;

        Node(Object obj) {
            object = obj;
        }
    }
    private class iterator implements Iterator{

        Node nodes = head;

        public boolean hasNext() {
            return nodes != null;
        }

        public Object next() {
            Object ob = nodes.object;
            nodes = nodes.next;
            return ob;

        }
    }


}


