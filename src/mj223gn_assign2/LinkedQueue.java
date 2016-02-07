package mj223gn_assign2;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by Michaels on 2016-02-07.
 */
public class LinkedQueue implements Queue {

    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue(){
        head = new
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
        if (head == null) {
            head = new Node(element);
            tail = head;
        }
        else {
            Node node = head;
            while (node.next != null )
                node = node.next;
            node.next = new Node(element);
            tail = node.next;
        }
        size ++;
    }

    @Override
    public Object dequeue() {

       return null;
    }

    @Override
    public Object first() {
        return head;
    }

    @Override
    public Object last() {
        return tail;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }

    private class Node {
        Object object;
        Node next = null;

        Node(Object obj) {
            object = obj;
        }
    }
}

