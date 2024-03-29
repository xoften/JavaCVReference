package mj223gn_assign4.BinaryHeap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;


/**
 * Test program to test our binaryIntHeap
 * Created by Michael Johansson(mj223gn) on 2016-03-11.
 */
public class BinaryIntHeapTest {

    private static int run = 0;

    @Before
    public void setUp(){
        System.out.print("Running Test method: " +(++run));
    }
    @After
    public void tearDown(){System.out.println(" -----------> Done with Test " +run); }

    @Test
    public void insertTest(){
        BinaryIntHeap test = new BinaryIntHeap();

        test.insert(3);
        test.insert(7);
        test.insert(15);

        //we test so 15 moves up to the parent
        assertEquals("The heap must be [15, 3, 7]","[15, 3, 7]", test.toString());

        test.insert(18);
        test.insert(11);
        test.insert(9);
        test.insert(21);
        test.insert(35);
        test.insert(14);

        //We check so the resize method works by adding the 10th element
        test.insert(1);
        test.insert(8);
        test.insert(25);

        //we check so out heap is correct
        assertEquals("The heap must be [35, 21, 25, 15, 11, 18, 9, 3, 14, 1, 8, 7]","[35, 21, 25, 15, 11, 18, 9, 3, 14, 1, 8, 7]", test.toString());

        }

    @Test (expected = NoSuchElementException.class)
    public void pullHighestTest(){
        BinaryIntHeap test = new BinaryIntHeap();
        //pullhighest on an empty heap we get an exception
        test.pullHighest();

        test.insert(5);
        test.insert(15);
        test.insert(13);
        test.insert(19);
        test.insert(7);

        //we test so the elemet comes out in the right order
        assertEquals("First out must be 19", 19, test.pullHighest());
        assertEquals("Next must be 15", 15, test.pullHighest());
        assertEquals("Next must be 13", 13, test.pullHighest());
    }
    @Test
    public void sizeTest(){
        BinaryIntHeap test = new BinaryIntHeap();

        //check so the size is 0 on an empty heap
        assertEquals("Size on empty heap must be 0", 0, test.size());

        //test that the size is 1 after we insert an element
        test.insert(1);
        assertEquals("Size on test heap must be 1", 1, test.size());

        for (int i = 1; i < 100;i++ ){
            test.insert(1);
        }
        //check so the size is 100
        assertEquals("the new size must be 100", 100, test.size());
    }
    @Test
    public void isEmptyTest(){
        BinaryIntHeap test = new BinaryIntHeap();

        //test isEmpty on an empty heap
        assertEquals("isEmpty on an empty heap must return true", true, test.isEmpty());

        test.insert(1);
        //test isEmpty on an heap with an element
        assertEquals("isEmpty on test heap must return false", false, test.isEmpty());

        test.pullHighest();
        //test heap again after we remove the element
        assertEquals("isEmpty on an empty heap must return true", true, test.isEmpty());
    }

}
