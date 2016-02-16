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
    public static int[] merge(int[] first, int[]second,)


    private static void sort(int[] in) {

        if (in.length <= 1)
            return;

        int[] first = new int[in.length / 2];
        int[] second = new int[in.length - first.length];
        for (int i = 0; i < first.length; i++) {
            first[i] = in[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = in[first.length + i];
        }
        sort(first);
        sort(second);

    }
}
