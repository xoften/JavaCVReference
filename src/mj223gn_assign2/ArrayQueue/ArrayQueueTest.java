package mj223gn_assign2.ArrayQueue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Hann inte fixa mer med dessa wordTest dock.....
 * Created by Michaels on 2016-02-14.
 */
public class ArrayQueueTest {
    private static int run = 0;

    @Before
    public void setUp(){
        System.out.print("Running wordTest method: " +(++run));
    }
    @After
    public void tearDown(){
        System.out.println(" ----------- done with wordTest " +run);
    }

    @Test
    public void enqueueSizeTest(){
        ArrayQueue test = new ArrayQueue();
        //add 10 numbers
        assertEquals("Size of empty queue must be 0", 0, test.size());
        for (int i = 0; i < 10; i++){
            test.enqueue(i);
        }
        //wordTest so that size is correct and the first and last is 1 and 10.
        assertEquals("Size of queue with 10 objects must be 10", 10, test.size());
        assertEquals("Element at head must be 0", 0, test.first());
        assertEquals("Element at tail must be 9", 9, test.last());

        //extrem wordTest that our linkedQueue works we high numbers.
        for (int i = 11; i <= 1000000; i++ ){
            test.enqueue(i);
        }
        assertEquals("Size of queue with 10000 elements must be 10000", 1000000, test.size());
        assertEquals("Element at tail must be 999999", 999999, test.last());
    }

    @Test
    public void dequeueIsEmptyTest(){
        ArrayQueue test = new ArrayQueue();
        //add 100 elements
        for (int i = 0; i <= 100; i++){
            test.enqueue(i);
        }
        //dequeue 10 times
        for (int i = 0; i < 10; i++){
            test.dequeue();
        }
        assertEquals("Method isEmpty on an queue with elements must be false", false, test.isEmpty());
        assertEquals("Element at head when we removed 10 must be 10", 10, test.first());

        for (int i = 0; i < 90; i++){
            test.dequeue();
        }
        //shall now be the same
        assertEquals(test.first(), test.last());

    }
    @Test (expected = NoSuchElementException.class)
    public void firstTest() {
        ArrayQueue test = new ArrayQueue();
        //nullpointer if we try to check the first element in an empty queue
        test.first();
    }
    @Test (expected = NoSuchElementException.class)
    public void lastTest(){
        ArrayQueue test = new ArrayQueue();
        //nullpointer if we try to check the last element in an empty queue
        test.last();
    }
    @Test
    public void toStringTest(){
        ArrayQueue test = new ArrayQueue();
        //add som objects
        test.enqueue("Hej");
        test.enqueue("Elite");
        test.enqueue("Haxxor");
        test.enqueue(1337);
        //then we wordTest if our toString returns the same answer
        assertEquals("| Hej Elite Haxxor 1337 |",test.toString());
    }

}
