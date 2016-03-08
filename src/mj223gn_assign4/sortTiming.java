package mj223gn_assign4;


import mj223gn_assign3.Algorithms.SortingAlgorithms;

import java.util.Random;

/**
 * Created by Michaels on 2016-03-07.
 */
public class sortTiming {

    public static void main(String[] args) {

        insertionSortIntTest(10, createIntArray(111000));
        mergeSortIntTest(10, createIntArray(7200000));
        insertionSortStringTest(10, createStringArray(11000));
        mergeSortStringTest(10, createStringArray(1000000));
    }
    public static int[] createIntArray(int n){
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(n*2);
        }
        return array;
    }
    public static String[] createStringArray(int n){
        Random random = new Random();
        String[] array = new String[n];
        for (int i = 0; i < n; i++){
            String out = "";
            for (int j = 0; j < 10; j++){
                int cha = random.nextInt(25)+97;
                out += (char) cha;
            }
            array[i] = out;
        }
        return array;
    }
    public static void insertionSortIntTest(int numberOfRuns, int[] array) {
        int time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            final long start = System.nanoTime();
            SortingAlgorithms.insertionSort(array);
            final long end = System.nanoTime();
            time += ((end - start) / 1000000);

        }
        System.out.println("Time for Int insertion: " + time/numberOfRuns);
        System.out.println("Length of sorted array: "+array.length);
    }
    public static void mergeSortIntTest(int numberOfRuns, int[] array){
        int time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            final long start = System.nanoTime();
            SortingAlgorithms.mergeSort(array);
            final long end = System.nanoTime();
            time += ((end - start) / 1000000);

        }
        System.out.println("Time for Int mergeSort: " + time/numberOfRuns);
        System.out.println("Length of sorted array: "+array.length);
    }
    public static void insertionSortStringTest(int numberOfRuns, String[] array) {
        int time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            final long start = System.nanoTime();
            SortingAlgorithms.insertionSort(array);
            final long end = System.nanoTime();
            time += ((end - start) / 1000000);

        }
        System.out.println("Time for String insertion: " + time/numberOfRuns);
        System.out.println("Length of sorted array: "+array.length);
    }
    public static void mergeSortStringTest(int numberOfRuns, String[] array){
        int time = 0;
        for (int i = 0; i < numberOfRuns; i++) {
            final long start = System.nanoTime();
            SortingAlgorithms.mergeSort(array);
            final long end = System.nanoTime();
            time += ((end - start) / 1000000);

        }
        System.out.println("Time for String mergeSort: " + time/numberOfRuns);
        System.out.println("Length of sorted array: "+array.length);
    }

}
