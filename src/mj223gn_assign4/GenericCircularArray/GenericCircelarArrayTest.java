package mj223gn_assign4.GenericCircularArray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;


import static org.junit.Assert.assertEquals;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-08.
 */
public class GenericCircelarArrayTest {
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
        GenericCircularArrayBased test = new GenericCircularArrayBased();

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

        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();

        assertEquals("IsEmpty method must return true on an empty queue", true, test.isEmpty());
        test.enqueue("Empty must be false!");
        assertEquals("IsEmpty method must return false on an queue with elements in it", false, test.isEmpty());

        assertEquals("IsEmpty method must return true on an empty queue", true, intTest.isEmpty());
        intTest.enqueue(123456789);
        assertEquals("IsEmpty method must return false on an queue with elements in it", false, intTest.isEmpty());
    }

    @Test
    public void enqueueTest() {
        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();

        test.enqueue("1");
        test.enqueue("ett");
        intTest.enqueue(1);
        intTest.enqueue(1337);

        assertEquals("First dequeue must be 1", "1", test.dequeue());
        assertEquals("Second dequeue must be ett", "ett", test.dequeue());

        assertEquals("First dequeue must be 1", new Integer(1), intTest.dequeue());
        assertEquals("Second dequeue must be 1337", new Integer(1337), intTest.dequeue());
    }

    @Test(expected = NullPointerException.class)
    public void dequeueTest() {
        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();

        test.enqueue("dequeue");
        test.enqueue("1337");

        intTest.enqueue(1337);
        intTest.enqueue(123);

        assertEquals("First dequeue must be \"dequeue\"", "dequeue", test.dequeue());
        assertEquals("Second dequeue must be 1337", "1337", test.dequeue());

        assertEquals("First dequeue must be 1337", new Integer(1337), intTest.dequeue());
        assertEquals("Second dequeue must be 123", new Integer(123), intTest.dequeue());

        //test that if we dequeue an empty queue we get an exception
        test.dequeue();
        intTest.dequeue();

    }

    @Test(expected = NullPointerException.class)
    public void firstTest() {
        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();
        //exception if we try to check the first element in an empty queue
        test.first();

        test.enqueue("first test");
        intTest.enqueue(123);

        assertEquals("First on test must be \"first test\"", "first test", test.first());
        assertEquals("First on test must be 123", new Integer(123), intTest.first());

    }

    @Test(expected = NullPointerException.class)
    public void lastTest() {
        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();

        //exception if we try to check the first element in an empty queue
        test.last();

        test.enqueue("first test");
        test.enqueue("123");

        intTest.enqueue(1337);
        intTest.enqueue(123);

        assertEquals("First on test must be 123", "123", test.last());
        assertEquals("First on test must be 123", new Integer(123), intTest.last());
    }

    @Test
    public void toStringTest() {
        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();

        assertEquals("Empty queue must return empty message", "Queue is empty!", test.toString());

        test.enqueue("first test");
        test.enqueue("Hej");
        test.enqueue("A");
        test.enqueue("Last");

        intTest.enqueue(123);
        intTest.enqueue(1337);

        assertEquals("[first test, Hej, A, Last]", test.toString());
        assertEquals("[123, 1337]", intTest.toString());
    }

    @Test(expected = NullPointerException.class)
    public void iteratorTest() {
        GenericCircularArrayBased<String> test = new GenericCircularArrayBased();
        GenericCircularArrayBased<Integer> intTest = new GenericCircularArrayBased();
        Iterator itr = test.iterator();
        Iterator intItr = intTest.iterator();

        assertEquals("hasNext must be false on an empty iterator", false, itr.hasNext());
        assertEquals("next must throw exception on an empty iterator", itr.next());
        assertEquals("hasNext must be false on an empty iterator", false, intItr.hasNext());
        assertEquals("next must throw exception on an empty iterator", intItr.next());

        test.enqueue("1");
        test.enqueue("2");
        test.enqueue("3");
        test.enqueue("4");
        itr = test.iterator();

        intTest.enqueue(1);
        intTest.enqueue(2);
        intTest.enqueue(3);
        intTest.enqueue(4);
        intItr = intTest.iterator();

        assertEquals("hasNext must be true", true, itr.hasNext());
        assertEquals("next must return 1", "1", itr.next());
        assertEquals("hasNext must be true", true, itr.hasNext());
        assertEquals("next must return 2", "2", itr.next());
        assertEquals("hasNext must be true", true, itr.hasNext());
        assertEquals("next must return 3", "3", itr.next());
        assertEquals("hasNext must be true", true, itr.hasNext());
        assertEquals("next must return 4", "4", itr.next());
        assertEquals("next must throw exception on an empty iterator", itr.next());

        assertEquals("hasNext must be true", true, intItr.hasNext());
        assertEquals("next must return 1", 1, intItr.next());
        assertEquals("hasNext must be true", true, intItr.hasNext());
        assertEquals("next must return 2", 2, intItr.next());
        assertEquals("hasNext must be true", true, intItr.hasNext());
        assertEquals("next must return 3", 3, intItr.next());
        assertEquals("hasNext must be true", true, intItr.hasNext());
        assertEquals("next must return 4", 4, intItr.next());
        assertEquals("next must throw exception on an empty iterator", intItr.next());
    }
}
