package mj223gn_assign4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michaels on 2016-03-04.
 */
public class QueueTest {

    private static int run = 0;

    @Before
    public void setUp() {
        System.out.print("Running test method: " + (++run));
    }

    @After
    public void tearDown() {
        System.out.println(" ----------- done with test " + run);
    }

    @Test
    public void sizeTest() {
        LinkedQueue test = new LinkedQueue();

        //add 10 numbers
        assertEquals("Size of empty queue must be 0", 0, test.size());
        for (int i = 1; i <= 10; i++) {
            test.enqueue(i);
        }
        //test so that size is correct and the first and last is 1 and 10.
        assertEquals("Size of queue with 10 objects must be 10", 10, test.size());
        assertEquals("Element at head must be 1", 1, test.first());
        assertEquals("Element at tail must be 10", 10, test.last());

        //extreme test that our linkedQueue works we high numbers.
        for (int i = 11; i <= 1000000; i++) {
            test.enqueue(i);
        }
        assertEquals("Size of queue with 10000 elements must be 10000", 1000000, test.size());
        assertEquals("Element at tail must be 10000", 1000000, test.last());

    }

    @Test
    public void isEmptyTest() {

        LinkedQueue test = new LinkedQueue();

        assertEquals("IsEmpty method must return true on an empty queue", true, test.isEmpty());
        test.enqueue("Empty must be false!");
        assertEquals("IsEmpty method must return false on an queue with elements in it", false, test.isEmpty());

    }

    @Test
    public void enqueueTest() {
        LinkedQueue test = new LinkedQueue();

        test.enqueue(1);
        test.enqueue("ett");
        test.enqueue('1');

        assertEquals("first dequeue must be 1 as integer", 1, test.dequeue());
        assertEquals("second dequeue must be ett as String", "ett", test.dequeue());
        assertEquals("third dequeue must be 1 as a char", '1', test.dequeue());

    }

    @Test(expected = NullPointerException.class)
    public void dequeueTest() {
        LinkedQueue test = new LinkedQueue();
        test.enqueue("dequeue");
        test.enqueue(1337);

        assertEquals("first dequeue must be \"dequeue\"", "dequeue", test.dequeue());
        assertEquals("Second dequeue must be 1337", 1337, test.dequeue());
        //test that if we dequeue an empty queue we get an exception
        test.dequeue();

    }

    @Test(expected = NullPointerException.class)
    public void firstTest() {
        LinkedQueue test = new LinkedQueue();
        //exception if we try to check the first element in an empty queue
        test.first();

        test.enqueue("first test");
        test.enqueue(123);
        assertEquals("First on test must be \"first test\"","first test", test.first());

    }
    @Test(expected = NullPointerException.class)
    public void lastTest() {
        LinkedQueue test = new LinkedQueue();
        //exception if we try to check the first element in an empty queue
        test.last();

        test.enqueue("first test");
        test.enqueue(123);
        assertEquals("First on test must be 123",123, test.last());

    }
    @Test
    public void toStringTest(){
        LinkedQueue test = new LinkedQueue();

        assertEquals("Empty queue must return empty message", "Queue is empty!", test.toString());

        test.enqueue("first test");
        test.enqueue(123);
        test.enqueue("Hej");
        test.enqueue(1337);
        test.enqueue('A');
        test.enqueue("Last");

        assertEquals("[first test, 123, Hej, 1337, A, Last]", test.toString());
    }
    @Test (expected = NullPointerException.class)
    public void iteratorTest(){
        LinkedQueue test = new LinkedQueue();
        Iterator itr = test.iterator();

        assertEquals("hasNext must be false on an empty iterator", false, itr.hasNext());
        assertEquals("next must throw exception on an empty iterator", itr.next());

        test.enqueue(1);
        itr = test.iterator();

        assertEquals("hasNext must be true", true, itr.hasNext());
        assertEquals("next must return 1", 1, itr.next());
        assertEquals("next must throw exception on an empty iterator", itr.next());
    }
}
