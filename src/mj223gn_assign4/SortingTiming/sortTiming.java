package mj223gn_assign4.SortingTiming;

import java.util.Random;

/**
 * Created by Michaels on 2016-03-07.
 */
public class sortTiming {

    public static void main(String[] args) {

        insertionSortIntTest(10, createIntArray(117000));
        mergeSortIntTest(10, createIntArray(7200000));
        insertionSortStringTest(10, createStringArray(13000));
        mergeSortStringTest(10, createStringArray(1300000));
    }

    /**
     * Method to create an array of random Integers
     *
     * @param n size of array
     * @return array with random Integers
     */
    public static int[] createIntArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n * 2);
        }
        return array;
    }

    /**
     * Method to create an array of random Strings with 10 random chars
     *
     * @param n size of array
     * @return array with random Strings
     */
    public static String[] createStringArray(int n) {
        Random random = new Random();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            String out = "";
            for (int j = 0; j < 10; j++) {
                int cha = random.nextInt(25) + 97;
                out += (char) cha;
            }
            array[i] = out;
        }
        return array;
    }

    /**
     * Test our insertionSort on an array with random Integers
     *
     * @param numberOfRuns how many times to sort the array
     * @param array        the array to sort
     */
    public static void insertionSortIntTest(int numberOfRuns, int[] array) {
        double time = 0.0;
        for (int i = 0; i < numberOfRuns; i++) {
            //set a start time
            final long start = System.nanoTime();
            SortingAlgorithms.insertionSort(array);
            //set a end time
            final long end = System.nanoTime();
            time += (end - start);
        }
        double average = (time / 1000000000.0) / numberOfRuns;
        System.out.printf("Time for int insertionSort: %.3f\n", average);
        System.out.println("Length of sorted array: " + array.length);
    }

    /**
     * Test our mergeSort on an array of random Integers
     *
     * @param numberOfRuns how many times to sort the array
     * @param array        the array to sort
     */
    public static void mergeSortIntTest(int numberOfRuns, int[] array) {
        double time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            //set a start time
            final long start = System.nanoTime();
            SortingAlgorithms.mergeSort(array);
            //set a end time
            final long end = System.nanoTime();
            time += (end - start);
        }
        double average = (time / 1000000000.0) / numberOfRuns;
        System.out.printf("Time for int mergeSort: %.3f\n", average);
        System.out.println("Length of sorted array: " + array.length);
    }

    /**
     * Test our insertionSort on an array of random Strings
     *
     * @param numberOfRuns how many times to sort the array
     * @param array        the array to sort
     */
    public static void insertionSortStringTest(int numberOfRuns, String[] array) {
        double time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            //set a start time
            final long start = System.nanoTime();
            SortingAlgorithms.insertionSort(array);
            //set a end time
            final long end = System.nanoTime();
            time += (end - start);

        }
        double average = (time / 1000000000.0) / numberOfRuns;
        System.out.printf("Time for String insertionSort: %.3f\n", average);
        System.out.println("Length of sorted array: " + array.length);
    }

    /**
     * Test our mergeSort on an array of random Strings
     *
     * @param numberOfRuns how many times to sort the array
     * @param array        the array to sort
     */
    public static void mergeSortStringTest(int numberOfRuns, String[] array) {
        double time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            //set a start time
            final long start = System.nanoTime();
            SortingAlgorithms.mergeSort(array);
            //set a end time
            final long end = System.nanoTime();
            time += (end - start);

        }
        double average = (time / 1000000000.0) / numberOfRuns;
        System.out.printf("Time for String mergeSort: %.3f\n", average);
        System.out.println("Length of sorted array: " + array.length);
    }

}
