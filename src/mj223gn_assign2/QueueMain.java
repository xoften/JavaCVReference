package mj223gn_assign2;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-02-07.
 */
public class QueueMain {

    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();

        System.out.println("Is our new LinkedQueue empty?: "+queue.isEmpty());

        System.out.print("If the queue is empty and we want to print it out we get: ");
        System.out.println(queue.toString());

        System.out.println("we add some objects to the queue");
        queue.enqueue("hej");
        queue.enqueue("Michael!");
        queue.enqueue(3);
        queue.enqueue("hej då!");


        System.out.println("Size of the queue is now: "+queue.size());

        System.out.println("If we use the iterator to go through the elements: ");
        Iterator itr = queue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("If we use the toString method to print them out: " + queue.toString());

        System.out.println("We check the first element: " + queue.first() + " and the last element: " + queue.last());

        System.out.println("We check the size before we remove from the queue: " +queue.size());
        queue.dequeue();

        System.out.println("After we remove the first element, we check the new first: " + queue.first() + " and the new size: " + queue.size());


    }



}
