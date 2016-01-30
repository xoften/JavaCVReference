package mj223gn_assign1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-27.
 */
public class PrintJavaMain {

    public static void main(String[] args) {
        try {
            File startDirectory = new File("C:\\Users\\Michaels\\IdeaProjects\\1DV507\\src");
            if (startDirectory.exists())
                printAllJavaFiles(startDirectory);
            else
                System.out.println("The directory does not exist.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {

        }
    }

    private static int indent = 1;

    private static void printAllJavaFiles(File start) throws IOException {
        File[] files = start.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                printFile(f);
                indent++;
                printAllJavaFiles(f);
            } else if (f.isFile()) {
                if (f.getName().endsWith(".java")) {
                    printFile(f);

                }
            }
        }
        indent--;

    }

    private static void printFile(File file) throws IOException {
        StringBuffer print = new StringBuffer();
        for (int i = 0; i < indent; i++) {
            print.append("  ");
        }
        if (file.getName().endsWith(".java"))
            System.out.println(print.toString() + file.getName() + "size = " + numberOfRows(file) + " rows");
        else
            System.out.println(print.toString() + file.getName());

    }

    private static int numberOfRows(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        LineNumberReader rowsReader = new LineNumberReader(fileReader);
        int rows = 0;
        while (rowsReader.readLine() != null)
            rows++;
        fileReader.close();
        rowsReader.close();
        return rows;
    }
}
