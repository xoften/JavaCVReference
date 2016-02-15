package mj223gn_assign3;

/**
 * Class to implement Euklides.
 * Created by Michael Johansson(mj223gn) on 2016-02-15.
 */
public class EuclideanAlgotiyhm {

    public static void main(String[] args) {

        int n = 9;
        int k = 28;

        System.out.println(Euclidean(n, k));

    }

    /**
     * Static method to calculate
     * @param n
     * @param k
     * @return
     */
    private static int Euclidean(int n, int k){
        int a;
        int b;
        int c;

        if(n < k) {
            b = n;
            a = k;
        }
        else {
            a = n;
            b = k;
        }
        while(b != 0){

            c = a % b;
            a = b;
            b = c;

        }
        return a;
    }
}
