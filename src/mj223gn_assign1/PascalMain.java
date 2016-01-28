package mj223gn_assign1;

import java.util.Arrays;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-27.
 */
public class PascalMain {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PascalTriangle(6)));
    }
    public static int[] PascalTriangle(int n)
    {   //pascals triangle starts at row zero.
        //we create an array that is 1 space larger then n.
        int[] triangle = new int[n+1];
        //base case is when row i zero and we get the top array with just one 1.
        if(n == 0)
        {
            triangle[0] = 1;
            return triangle;
        }
        else {
            //we create a smaller array while n != 0;
            int[] previousTriangle = PascalTriangle(n - 1);
            //we set the first and last element in the array to 1
            triangle[0] = triangle[n] = 1;
            /**while i is less then the previous triangle length we add element i + element i-1 from
             * the previous triangle and set it as the element at position i in our triangle array.
             **/
            for (int i = 1; i < previousTriangle.length; i++) {
                triangle[i] = previousTriangle[i - 1] + previousTriangle[i];
            }
        }
        return triangle;
    }
}


