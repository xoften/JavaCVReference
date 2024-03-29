package mj223gn_assign1;

import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-25.
 * Class to check if timing for recursive and iterative methods for the sum of adding 1+2+3...+n;
 */
public class SumMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Insert a positive integer: ");

        //Take an long from them user and sets it to n;
        long n = input.nextLong();

        if (n < 0)
            System.out.println("You did not insert a positive integer");
        else {
            //We take time on the methods
            final long startTime1 = System.nanoTime();
            //Method one with the 1 to n/2 + (n/2)+1 to n.
            System.out.println("The sum of the numbers 1+2+3...+n = " + sum(1,n));

            final long endTime1 = System.nanoTime();
            System.out.println("time = " + (endTime1 - startTime1)/1000000.0 + " ms");


            final long startTime2 = System.nanoTime();

            //Method two that Jonas used in the slides
            System.out.println("The sum of the numbers 1+2+3...+n = " + sum2(n));
            final long endTime2 = System.nanoTime();
            System.out.println("time = " + (endTime2 - startTime2)/1000000.0 + " ms");

            final long startTime3 = System.nanoTime();

            //Method three is iterative
            System.out.println("The sum of the numbers 1+2+3...+n = " + sumIterator(n));
            final long endTime3 = System.nanoTime();
            System.out.println("time = " + (endTime3 - startTime3)/1000000.0 + " ms");

            /**
             * We see that our first method with 1 to n/2 + n/2+1 to n can calculate larger numbers then the other two
             * with not getting a stack overflow. but for smaller numbers it is slower. so for larger numbers we should
             * use this but with smaller we should use a iterative.
             *
             */

            input.close();
        }
    }

    /**
     * Exercise 3 method that goes from 1 to n/2 + n/2+1 to n, this method is slow but can calculate
     * large numbers for n.
     * @param k the smallest number
     * @param n the largest number
     * @return sum for all numbers from 1-n
     */
    private static long sum(long k, long n){
        //base case
        if(n == k)
            return n;
        else
            return sum(k,(n+k)/2) + sum(((n+k)/2)+1,n);


    }

    /**
     * Method Jonas showed i slides, little faster then the one for this exercise, but it cant handle as large numbers
     * the then one above.
     * @param n the last number
     * @return sum of all numbers from 1 to n
     */
    private static long sum2(long n){
        //Base case
        if(n == 1)
            return 1;
        //else we use sum again but with a smaller number
        else
            return sum2(n-1) + n;

    }

    /**
     * Iterative method to add all numbers from 1 to n. its the fastest of all methods. but as the one Jonas showed us
     * it cant handle very large numbers.
     * @param n the last number
     * @return sum of all numbers from 1-n
     */
    private static long sumIterator(long n){

        int sum = 0;
        for(int i = 1; i <= n; i++){
            //for every new loop we add i to the sum variable
            sum += i;
        }
        return sum;
    }

}

