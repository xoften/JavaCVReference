package mj223gn_assign3.Algorithms;

import java.util.Arrays;

/**
 * Created by Michaels on 2016-02-15.
 */
public class SortingAlgorithms {

    public static void main(String[] args) {

        int[] test = new int[]{54,2,43,8,19,25,34};
        System.out.println(Arrays.toString(insertionSort(test)));

    }
    public static int[] insertionSort(int[] in){

        int[] sorted = in.clone();

        for (int i = 1; i < in.length; i++){
            int previous = sorted[i];
            int next = i;
            while (next > 0 && sorted[next-1] > previous){
                sorted[next] = sorted[next-1];
                next = next-1;
            }
            sorted[next] = previous;
        }

        return sorted;
    }

}
