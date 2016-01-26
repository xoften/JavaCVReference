package mj223gn_assign1;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-26.
 */
public class SumSum {

    public static void main(String[] args) {
        System.out.println(sum(1,21349));
    }

    private static long sum(int k, int n){
        if(n == k)
            return 1;
        else
            return sum(k,(n+k)/2) + sum(((n+k)/2)+1,n) + (k+n)/2;


    }
}
