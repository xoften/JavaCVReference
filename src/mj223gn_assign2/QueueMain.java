package mj223gn_assign2;

/**
 * Created by Michaels on 2016-02-07.
 */
public class QueueMain {

    public static void main(String[] args) {


        LinkedQueue h = new LinkedQueue();



        h.enqueue("hej");
        h.enqueue("då!");

        System.out.println(h.first());

        System.out.println(h.size());
        h.dequeue();

        System.out.println(h.first());

        System.out.println(h.size());




    }



}
