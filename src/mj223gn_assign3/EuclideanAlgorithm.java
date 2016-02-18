package mj223gn_assign3;

import java.util.Scanner;

/**
 * Class to implement Euclidean algorithm to find the greatest common divider.
 * Created by Michael Johansson(mj223gn) on 2016-02-15.
 */
public class EuclideanAlgorithm {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n;
        int k;
        do {
            System.out.print("Write in two integers(both cant be zero!): ");
            n = input.nextInt();
            k = input.nextInt();
        }while ( n == 0 && k ==0);

        System.out.println(Euclidean(n, k));

    }

    /**
     * Static method to calculate
     * @param n first integer
     * @param k second integer
     * @return Greatest common divider
     */
    private static int Euclidean(int n, int k){
        int a;
        int b;
        int c;

        //if k is larger then n we set k to a and n to b.
        if(n < k) {
            b = n;
            a = k;
        }
        //else we set n to a and k to b;
        else {
            a = n;
            b = k;
        }
        /**
         * while b is not equal to zero we set c to a modulus b then a to b and b to c.
         * when b is zero we return the greatest common divider that is a.
         */
        while(b != 0){

            c = a % b;
            a = b;
            b = c;

        }
        return Math.abs(a);
    }
}
