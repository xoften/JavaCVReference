package mj223gn_assign4;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-07.
 */
public class StringConcatenations {

    public static void main(String[] args) {
        //shortConcatenation();
        //longConcatenation();
        //shortStringBuilder();
        longStringBuilder();

    }

    public static void shortConcatenation() {
            String out = "";
            final long start = System.nanoTime();
            for (int j = 0; j < 35000; j++) {
                out += "y";
            }
            final long end = System.nanoTime();
            System.out.println("Time is: " + (end - start) / 1000000 + " ms");
            System.out.println("Number of chars in string: " + out.length());
            System.out.println("Number of iterations: " + out.length());
        }

    public static void longConcatenation() {
        String out = "";
        final long start = System.nanoTime();
        for (int j = 0; j < 4500; j++) {
            out += "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        }
        final long end = System.nanoTime();
        System.out.println("Time is: " + (end - start) / 1000000 + " ms");
        System.out.println("Number of chars in string: " + out.length());
        System.out.println("Number of iterations: "+(out.length()/80));
    }

    public static void shortStringBuilder() {
        StringBuilder out = new StringBuilder();
        final long start = System.nanoTime();
        for (int j = 0; j < 130000000; j++) {
            out.append("x");
        }
        out.toString();
        final long end = System.nanoTime();
        System.out.println("Time is: " + (end - start) / 1000000 + " ms");
        System.out.println("Number of chars in string: " + out.toString().length());
        System.out.println("Number of iterations: "+ out.length());
    }

    public static void longStringBuilder() {
        for (int i = 0; i < 10; i++) {
            StringBuilder out = new StringBuilder();
            final long start = System.nanoTime();
            for (int j = 0; j < 4299999; j++) {
                out.append("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
            }
            out.toString();
            final long end = System.nanoTime();
            System.out.println("Time is: " + (end - start) / 1000000 + " ms");
            System.out.println("Number of chars in string: " + out.toString().length());
            System.out.println("Number of iterations: " + (out.length() / 80));
        }
    }

}
