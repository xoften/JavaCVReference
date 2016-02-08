package mj223gn_assign2;

/**
 * Created by Michaels on 2016-02-07.
 */
public class QueueMain {

    public static void main(String[] args) {


        LinkedQueue h = new LinkedQueue();

        System.out.println(h.isEmpty());
        System.out.println(h.toString());

        h.enqueue("hej");
        h.enqueue("då!");
        h.enqueue(3);
        h.enqueue("kalle");
        System.out.println(h.size());

        System.out.println(h.toString());
        System.out.println(h.last());
        System.out.println(h.first());

        System.out.println(h.size());
        h.dequeue();

        System.out.println(h.first());
        System.out.println(h.isEmpty());
        System.out.println(h.size());




    }



}
