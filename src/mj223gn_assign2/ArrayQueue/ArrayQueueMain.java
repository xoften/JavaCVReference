package mj223gn_assign2.ArrayQueue;

import java.util.Iterator;

/**
 * Test main för eget bruk
 * Created by Michaels on 2016-02-14.
 */
public class ArrayQueueMain {


    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue();

        System.out.println("See that resize work: "+ queue.getLength());

        for (int i = 1; i < 12; i++){
            queue.enqueue(i);
        }
        System.out.println(queue.first());
        System.out.println(queue.last());

        System.out.println("ToString test: "+queue.toString());

        for (int i = 0; i < 5; i++){
            queue.dequeue();
        }

        Iterator itr = queue.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

        System.out.println("ToString test: " + queue.toString());

        System.out.println("See that resize work: "+ queue.getLength());
    }

}
