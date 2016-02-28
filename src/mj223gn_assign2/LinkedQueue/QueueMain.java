package mj223gn_assign2.LinkedQueue;

import java.util.Iterator;

/**
 * Main program to show how our linked queue works
 * Created by Michaels on 2016-02-07.
 */
public class QueueMain {

    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();

        System.out.println("Is our new LinkedQueue empty?: "+queue.isEmpty());

        System.out.print("If the queue is empty and we want to toArray it out we get: ");
        System.out.println(queue.toString());

        System.out.println("we add some objects to the queue");
        queue.enqueue("Hej");
        queue.enqueue("Michael!");
        queue.enqueue(1337);
        queue.enqueue("hej då!");

        System.out.println("Size of the queue is now: "+queue.size());

        System.out.print("If we use the iterator to go through the elements: ");
        Iterator itr = queue.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next()+ " ");
        }
        System.out.println();

        System.out.println("If we use the toString method to toArray them out: " + queue.toString());

        System.out.println("We check the first element: " + queue.first() + " and the last element: " + queue.last());

        System.out.println("We check the size before we remove from the queue: " +queue.size());
        queue.dequeue();

        System.out.println("After we remove the first element, we check the new first: " + queue.first() + " and the new size: " + queue.size());


    }



}
