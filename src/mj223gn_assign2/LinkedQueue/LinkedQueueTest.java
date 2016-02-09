package mj223gn_assign2.LinkedQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for our LinkedQueue with JUnit
 * Created by Michael Johansson(mj223gn) on 2016-02-09.
 */
public class LinkedQueueTest {
    private static int run = 0;

    @Before
    public void setUp(){
        System.out.print("Running test method: " +(++run));
    }
    @After
    public void tearDown(){
        System.out.println(" ----------- done with test " +run);
    }

    @Test
    public void enqueueSizeTest(){
        LinkedQueue test = new LinkedQueue();
        assertEquals("Size of empty queue must be 0", 0, test.size());
        for (int i = 1; i <= 10; i++){
            test.enqueue(i);
        }
        assertEquals("Size of queue with 10 objects must be 10", 10, test.size());
        assertEquals("Element at head must be 1", 1, test.first());
        assertEquals("Element at tail must be 10", 10, test.last());
        for (int i = 11; i <= 1000000; i++ ){
            test.enqueue(i);
        }
        assertEquals("Size of queue with 10000 elements must be 10000", 1000000, test.size());
        assertEquals("Element at tail must be 10000", 1000000, test.last());
    }

    @Test (expected = NullPointerException.class)
    public void dequeueIsEmptyTest(){
        LinkedQueue test = new LinkedQueue();
        //add 100 elements
        for (int i = 1; i <= 100; i++){
            test.enqueue(i);
        }
        //dequeue 10 times
        for (int i = 0; i < 10; i++){
            test.dequeue();
        }
        assertEquals("Method isEmpty on an queue with elements must be false", false, test.isEmpty());
        assertEquals("Element at head when we removed 10 must be 11", 11, test.first());

        //dequeue to there is one element last
        for (int i = 0; i <= 90; i++){
            test.dequeue();
        }
        //now the head and tail must be the same
        assertEquals(test.first(), test.last());

        //force exception
        test.dequeue();
    }
    @Test (expected = NullPointerException.class)
    public void firstTest() {
        LinkedQueue test = new LinkedQueue();
        //nullpointer if we try to check the first element in an empty queue
        test.first();
    }
}
