package mj223gn_assign4;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-07.
 */
public class StringConcatenations {

    public static void main(String[] args) {
        //shortConcatenation();
        longConcatenation();
        //shortStringBuilder(10);
        //longStringBuilder(10);

    }

    public static void shortConcatenation() {
        String out = "";
        final long start = System.nanoTime();
        for (int j = 0; j < 3000; j++) {
            out += "y";
        }
        final long end = System.nanoTime();
        System.out.println((end - start) / 1000000);
        System.out.println(out.length());
    }

    public static void longConcatenation() {
        String out = "";
        final long start = System.nanoTime();
        for (int j = 0; j < 3150; j++) {
            out += "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        }
        final long end = System.nanoTime();
        System.out.println((end - start) / 1000000);
        System.out.println((out.length()/80));
    }

    public static void shortStringBuilder(int n) {
        StringBuilder out = new StringBuilder();
        final long start = System.nanoTime();
        for (int j = 0; j < 70000000; j++) {
            out.append("x");
        }
        out.toString();
        final long end = System.nanoTime();
        System.out.println((end - start) / 1000000);
        System.out.println(out.toString().length());
    }

    public static void longStringBuilder(int n) {
        StringBuilder out = new StringBuilder();
        final long start = System.nanoTime();
        for (int j = 0; j < 3300000; j++) {
            out.append("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
        out.toString();
        final long end = System.nanoTime();
        System.out.println((end - start) / 100000000);
        System.out.println(out.toString().length());
    }


}
