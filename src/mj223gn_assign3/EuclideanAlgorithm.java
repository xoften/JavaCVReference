package mj223gn_assign3;

/**
 * Class to implement Euklides.
 * Created by Michael Johansson(mj223gn) on 2016-02-15.
 */
public class EuclideanAlgorithm {

    public static void main(String[] args) {

        int n = 9;
        int k = 28;

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
        return a;
    }
}
