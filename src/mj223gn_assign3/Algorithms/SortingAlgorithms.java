package mj223gn_assign3.Algorithms;

import java.util.Arrays;

/**
 * class with sorting algorithms, i have insertion sort and merge sort. Both is overloaded to take int arrays and string arrays.
 * Created by Michaels on 2016-02-15.
 */
public class SortingAlgorithms {

    public static void main(String[] args) {
        //test arrayer
        int[] test = new int[]{96,15,-25,10000,89,1,0,78,9,-99,100,96,854};
        String[] testString = new String[]{"michael","Peter", "Patrik", "Michael","Peter","Adam","","Karl","michael","Sixten","Johan","adam"};
        //output
        System.out.println(Arrays.toString(insertionSort(test)));
        System.out.println(Arrays.toString(mergeSort(test)));
        System.out.println(Arrays.toString(insertionSort(testString)));
        System.out.println(Arrays.toString(mergeSort(testString)));
        //test so we dont change start array.
        System.out.println(Arrays.toString((test)));
        System.out.println(Arrays.toString(testString));
    }

    /**
     * Insertion sort algorithm that clone the array and return a new sorted array.
     * I have taken inspiration from CS50 on youtube: https://www.youtube.com/watch?v=DFG-XuyPYUQ
     *
     * @param in array to sort
     * @return sorted array
     */
    public static int[] insertionSort(int[] in) {
        //clone the inputed array.
        int[] sorted = in.clone();

        //for check every element from index 1 to last.
        //If element at index 1 is smaller then 0 we change position and so on...
        for (int i = 1; i < in.length; i++) {
            //next element to check
            int next = sorted[i];
            //index of the previous element to check against
            int previousIndex = i;
            // while the previous element is not zero, and while element at previous
            //index is lager then next
            while (previousIndex > 0 && sorted[previousIndex - 1] > next) {
                //we move back the element at previous one step
                sorted[previousIndex] = sorted[previousIndex - 1];
                //then we reduce the previous with one.
                previousIndex = previousIndex - 1;
            }
            //when we exit the for loop the next previousIndex is less then next so we pu
            //in next at this index.
            sorted[previousIndex] = next;
        }
        return sorted;
    }

    /**
     * Insertion sort for Strings.
     * @param in array to sort
     * @return new sorted array.
     */
    public static String[] insertionSort(String[] in) {
        //clone the inputed array.
        String[] sorted = in.clone();

        //for check every element from index 1 to last.
        //If element at index 1 is smaller then 0 we change position and so on...
        for (int i = 1; i < in.length; i++) {
            //next element to check
            String next = sorted[i];
            //index of the previous element to check against
            int previousIndex = i;
            // while the previous index is not zero, and while element at previous
            //index is lager then next
            while (previousIndex > 0 && next.compareToIgnoreCase(sorted[previousIndex - 1])<=0) {

                //we move back the element at previous one step
                sorted[previousIndex] = sorted[previousIndex - 1];
                //then we reduce the previous with one.
                previousIndex = previousIndex - 1;
            }
            //when we exit the for loop the next previousIndex is less then next so we pu
            //in next at this index.
            sorted[previousIndex] = next;
        }
        return sorted;
    }

    /**
     * Merge sort algorithm. That clones our array and calls our private methods
     * I have taken inspiration from the book.
     *
     * @param in array to sort
     * @return new sorted array.
     */
    public static int[] mergeSort(int[] in) {
        //clone array
        int[] sorted = in.clone();
        //call the sort method
        sort(sorted);
        //return the sorted array.
        return sorted;
    }

    /**
     * sorting method
     * @param in array to sort
     */
    private static void sort(int[] in) {
        //base case where the array is 1 in length
        if (in.length <= 1)
            return;
        //split the array into two smaller arrays.
        int[] firstHalf = new int[in.length / 2];
        int[] secondHalf = new int[in.length - firstHalf.length];
        //put in the elements in each split array
        //first array
        for (int i = 0; i < firstHalf.length; i++) {
            firstHalf[i] = in[i];
        }
        //second array.
        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = in[firstHalf.length + i];
        }
        //recursive call to continue to split the arrays until base case.
        sort(firstHalf);
        sort(secondHalf);
        //the we merge and sort the arrays.
        merge(firstHalf, secondHalf, in);

    }

    /**
     * Method to merge two arrays
     * @param firstHalf array one
     * @param secondHalf array two
     * @param sorted sorted merged array.
     */
    private static void merge(int[] firstHalf, int[] secondHalf, int[] sorted) {
        //index for our arrays
        int indexFirst = 0;
        int indexSecond = 0;
        int indexMergedArray = 0;

        //while the length is larger then index for each index of the arrays.
        while (firstHalf.length > indexFirst && secondHalf.length > indexSecond) {
            //if the element of first array at index for that array is larger then the second, we set the element at index
            //of the sorted array to the in first array. and increase the index of first by one.
            if (firstHalf[indexFirst] < secondHalf[indexSecond]) {
                sorted[indexMergedArray] = firstHalf[indexFirst];
                indexFirst++;
            }
            //else we put the element in the second array into the sorted array.
            else {
                sorted[indexMergedArray] = secondHalf[indexSecond];
                indexSecond++;
            }
            //then we add one to the index of sorted array.
            indexMergedArray++;
        }
        //then we just add the left over numbers. if one array is larger then the other we get one number left
        //so its here we add that.
        while (indexFirst < firstHalf.length) {
            sorted[indexMergedArray] = firstHalf[indexFirst];
            indexFirst++;
            indexMergedArray++;
        }
        while (indexSecond < secondHalf.length) {
            sorted[indexMergedArray] = secondHalf[indexSecond];
            indexSecond++;
            indexMergedArray++;
        }
    }

    /**
     * Merge sort algorithm. That clones our array and calls our private methods
     * @param in array to sort
     * @return new sorted array.
     */
    public static String[] mergeSort(String[] in) {
        //clone array
        String[] sorted = in.clone();
        //call the sort method
        sort(sorted);
        //return the sorted array.
        return sorted;
    }

    /**
     * sorting method
     * @param in array to sort
     */
    private static void sort(String[] in) {
        //base case where the array is 1 in length
        if (in.length <= 1)
            return;
        //split the array into two smaller arrays.
        String[] firstHalf = new String[in.length / 2];
        String[] secondHalf = new String[in.length - firstHalf.length];
        //put in the elements in each split array
        //first array
        for (int i = 0; i < firstHalf.length; i++) {
            firstHalf[i] = in[i];
        }
        //second array.
        for (int i = 0; i < secondHalf.length; i++) {
            secondHalf[i] = in[firstHalf.length + i];
        }
        //recursive call to continue to split the arrays until base case.
        sort(firstHalf);
        sort(secondHalf);
        //the we merge and sort the arrays.
        merge(firstHalf, secondHalf, in);

    }

    /**
     * Method to merge two arrays
     * @param firstHalf array one
     * @param secondHalf array two
     * @param sorted sorted merged array.
     */
    private static void merge(String[] firstHalf, String[] secondHalf, String[] sorted) {
        //index for our arrays
        int indexFirst = 0;
        int indexSecond = 0;
        int indexMergedArray = 0;

        //while the length is larger then index for each index of the arrays.
        while (firstHalf.length > indexFirst && secondHalf.length > indexSecond) {
            if(firstHalf[indexFirst].toLowerCase().equals((secondHalf[indexSecond].toLowerCase()))){
                if (firstHalf[indexFirst].compareTo(secondHalf[indexSecond])<0) {
                    sorted[indexMergedArray] = firstHalf[indexFirst];
                    indexFirst++;
                }
                //else we put the element in the second array into the sorted array.
                else {
                    sorted[indexMergedArray] = secondHalf[indexSecond];
                    indexSecond++;
                }
                indexMergedArray++;
            }else {
                //if the element of first array at index for that array is larger then the second, we set the element at index
                //of the sorted array to the in first array. and increase the index of first by one.
                if (firstHalf[indexFirst].compareToIgnoreCase(secondHalf[indexSecond]) < 0) {
                    sorted[indexMergedArray] = firstHalf[indexFirst];
                    indexFirst++;
                }
                //else we put the element in the second array into the sorted array.
                else {
                    sorted[indexMergedArray] = secondHalf[indexSecond];
                    indexSecond++;
                }
                //then we add one to the index of sorted array.
                indexMergedArray++;
            }
        }
        //then we just add the left over numbers. if one array is larger then the other we get one number left
        //so its here we add that.
        while (indexFirst < firstHalf.length) {
            sorted[indexMergedArray] = firstHalf[indexFirst];
            indexFirst++;
            indexMergedArray++;
        }
        while (indexSecond < secondHalf.length) {
            sorted[indexMergedArray] = secondHalf[indexSecond];
            indexSecond++;
            indexMergedArray++;
        }
    }
}
