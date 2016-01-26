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

            //this method is the recursive
            System.out.println("The sum of the numbers 1+2+3...+n = " + sum(n));
            final long endTime1 = System.nanoTime();
            System.out.println("time = " + (endTime1 - startTime1)/10000);

            final long startTime2 = System.nanoTime();

            //this method is the iterative
            System.out.println("The sum of the numbers 1+2+3...+n = " + sumIterator(n));
            final long endTime2 = System.nanoTime();
            System.out.println("time = " + (endTime2 - startTime2)/10000);


        }
    }

    public static long sum(long n){
        //Base case
        if(n == 1)
            return 1;
        //else we use sum again but with a smaller number
        else
            return sum(n-1) + n;

    }
    public static long sumIterator(long n){

        int sum = 0;
        for(int i = 1; i <= n; i++){
            //for every new loop we add i to the sum variable
            sum += i;
        }
        return sum;
    }

}

