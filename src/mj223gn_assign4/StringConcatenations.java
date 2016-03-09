package mj223gn_assign4;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-07.
 */
public class StringConcatenations {

    final static double NANO_IN_ONE_SEC = 1000000000.0;

    public static void main(String[] args) {
        //run them one by one to get a cold start of the JVM
        //shortConcatenation(38800);
        //longConcatenation(4600);
        //shortStringBuilder(96000000);
        longStringBuilder(4100000);

    }

    /**
     *
     * Method to take time on a short concatenation
     * @param iterations number of times to add a string
     */
    public static void shortConcatenation(int iterations) {

        String out = "";
        //set a start time
        final long start = System.nanoTime();
        for (int j = 0; j < iterations; j++) {
            out += "y";
        }
        //sets a end time
        final long end = System.nanoTime();
        System.out.printf("Time is: %.2f s\n", (end - start) / NANO_IN_ONE_SEC);
        System.out.println("Number of chars in string: " + out.length());
        System.out.println("Number of iterations: " + out.length());
    }

    /**
     * Method to take time on a long concatenation
     * @param iterations number of times to add a string
     */
    public static void longConcatenation(int iterations) {

        String out = "";
        //set a start time
        final long start = System.nanoTime();
        for (int j = 0; j < iterations; j++) {
            out += "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        }
        //sets a end time
        final long end = System.nanoTime();
        System.out.printf("Time is: %.2f s\n", (end - start) / NANO_IN_ONE_SEC);
        System.out.println("Number of chars in string: " + out.length());
        System.out.println("Number of iterations: " + (out.length() / 80));
    }

    /**
     * Method to take time on a short append
     * @param iterations number of times to add a string
     */
    public static void shortStringBuilder(int iterations) {

        StringBuilder out = new StringBuilder();
        //set a start time
        final long start = System.nanoTime();
        for (int j = 0; j < iterations; j++) {
            out.append("x");
        }
        out.toString();
        //sets a end time
        final long end = System.nanoTime();
        System.out.printf("Time is: %.2f s\n", (end - start) / NANO_IN_ONE_SEC);
        System.out.println("Number of chars in string: " + out.toString().length());
        System.out.println("Number of iterations: " + out.length());
    }

    /**
     * Method to take time on a long append.
     * @param iterations number of times to add a string
     */
    public static void longStringBuilder(int iterations) {

        StringBuilder out = new StringBuilder();
        //set a start time
        final long start = System.nanoTime();
        for (int j = 0; j < iterations; j++) {
            out.append("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        }
        out.toString();
        //sets a end time
        final long end = System.nanoTime();
        System.out.printf("Time is: %.2f s\n", (end - start) / NANO_IN_ONE_SEC);
        System.out.println("Number of chars in string: " + out.toString().length());
        System.out.println("Number of iterations: " + (out.length() / 80));
    }


}
