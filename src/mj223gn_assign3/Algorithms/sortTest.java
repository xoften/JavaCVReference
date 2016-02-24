package mj223gn_assign3.Algorithms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-17.
 */
public class sortTest {

    private static int run = 0;
    private static int[] intTest = new int[]{10,67,54,-76,19,56,100,48,-1,78};
    private static String[] stringTest = new String[]{"michael", "Mårten", "Daniel", "patrik","","adam" ,"Michael", "Peter", "mattias"};

    @Before
    public void setUp(){
        System.out.println("Running test method: " +(++run));
    }
    @After
    public void tearDown(){
        System.out.println("Done with test " +run + "\n");

    }

    @Test
    public void intInsertionSortTest(){
        //zero size array
        int[] zero = new int[0];
        //array with size 1
        int[] one = new int[]{100};
        //large array with size 10000, that has integers 9999-0
        int[] large = new int [100000];
        //large sorted array from 0-9999.
        int[] largeSorted = new int[100000];
        for (int i = 99999; i >= 0; i--)
            large[large.length-i-1] = i;
        for (int i = 0; i < 100000; i++)
            largeSorted[i] = i;

        assertArrayEquals("Test if large array also get sorted from 0-9999",largeSorted, SortingAlgorithms.insertionSort(large));
        assertArrayEquals("An array with size zero must return []", new int[]{}, SortingAlgorithms.insertionSort(zero));
        assertArrayEquals("An array with size 1 must return [100]", new int[]{100}, SortingAlgorithms.insertionSort(one));
        assertArrayEquals("Sorted array must be [-76, -1, 10, 19, 48, 54, 56, 67, 78, 100]", new int[]{-76, -1, 10, 19, 48, 54, 56, 67, 78, 100},
                SortingAlgorithms.insertionSort(intTest));
        System.out.println("Sorted test array: "+Arrays.toString(SortingAlgorithms.insertionSort(intTest)));

    }
    @Test
    public void stringInsertionSortTest(){
        //zero size array
        String[] zero = new String[0];
        //array with size 1
        String[] one = new String[]{"Michael"};
        //array to check that it sorts case sensitive
        String[] same = new String[]{"michael","Michael", "Michael", "michael", "michael", "michael", "Michael"};

        assertArrayEquals("An array with size zero must return []", new String[]{}, SortingAlgorithms.insertionSort(zero));
        assertArrayEquals("An array with size one must return [Michael]", new String[]{"Michael"}, SortingAlgorithms.insertionSort(one));

        //case sensitive
        assertArrayEquals("An array with the same string should be sorted case sensitive",
                new String[]{"Michael","Michael","Michael","michael","michael","michael","michael"},SortingAlgorithms.mergeSort(same));

        assertArrayEquals("Sorted stringTest must be [\"\",adam, Daniel, mattias, michael, Michael, Mårten, Patrik, Peter]",
                new String[]{"", "adam", "Daniel", "mattias", "Michael", "michael", "Mårten", "patrik", "Peter"},
                SortingAlgorithms.insertionSort(stringTest));
        System.out.println("Sorted test array: "+Arrays.toString(SortingAlgorithms.insertionSort(stringTest)));
    }
    @Test
    public void intMergeSortTest(){
        //zero size array
        int[] zero = new int[0];
        //array with size 1
        int[] one = new int[]{100};
        //large array with size 10000, that has integers 9999-0
        int[] large = new int [100000];
        //large sorted array from 0-9999.
        int[] largeSorted = new int[100000];
        for (int i = 99999; i >= 0; i--)
            large[large.length-i-1] = i;
        for (int i = 0; i < 100000; i++)
            largeSorted[i] = i;

        assertArrayEquals("Test if large array also get sorted from 0-9999",largeSorted, SortingAlgorithms.mergeSort(large));
        assertArrayEquals("An array with size zero must return []", new int[]{}, SortingAlgorithms.mergeSort(zero));
        assertArrayEquals("An array with size 1 must return [100]", new int[]{100}, SortingAlgorithms.mergeSort(one));
        assertArrayEquals("Sorted array must be [-76, -1, 10, 19, 48, 54, 56, 67, 78, 100]", new int[]{-76, -1, 10, 19, 48, 54, 56, 67, 78, 100},
                SortingAlgorithms.mergeSort(intTest));
        System.out.println("Sorted test array: "+Arrays.toString(SortingAlgorithms.mergeSort(intTest)));
    }

    @Test
    public void stringMergeSortTest(){
        //zero size array
        String[] zero = new String[0];
        //array with size 1
        String[] one = new String[]{"Michael"};
        //array to check that it sorts case sensitive
        String[] same = new String[]{"michael","Michael", "Michael", "michael", "michael", "michael", "Michael"};

        assertArrayEquals("An array with size zero must return []", new String[]{}, SortingAlgorithms.mergeSort(zero));
        assertArrayEquals("An array with size one must return [Michael]", new String[]{"Michael"}, SortingAlgorithms.mergeSort(one));

        //case sensitive
        assertArrayEquals("An array with the same string should be sorted case sensitive",
                new String[]{"Michael","Michael","Michael","michael","michael","michael","michael"},SortingAlgorithms.mergeSort(same));

        //test the test array
        assertArrayEquals("Sorted stringTest must be [\"\",adam, Daniel, mattias, michael, Michael, Mårten, Patrik, Peter]",
                new String[]{"","adam", "Daniel", "mattias", "Michael", "michael", "Mårten", "patrik", "Peter"},
                SortingAlgorithms.mergeSort(stringTest));
        System.out.println("Sorted test array: "+Arrays.toString(SortingAlgorithms.mergeSort(stringTest)));

    }
    @Test
    public void timeTest(){
        //large array with size 10000, that has integers 9999-0
        int[] large = new int [100000];
        for (int i = 99999; i >= 0; i--)
            large[large.length-i-1] = i;

        final long startTimeInsertion = System.nanoTime();
        SortingAlgorithms.insertionSort(large);
        final long endTimeInsertion = System.nanoTime();
        System.out.println("Insertion on worst case for 100000 elements takes: " + (endTimeInsertion-startTimeInsertion)/1000000 + " ms.");

        final long startTimeMergeSort = System.nanoTime();
        SortingAlgorithms.mergeSort(large);
        final long endTimeMergeSort = System.nanoTime();
        System.out.println("MergeSort on worst case for 100000 elements takes: "+ (endTimeMergeSort-startTimeMergeSort)/1000000 + " ms.");
    }
}

