package mj223gn_assign1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-27.
 * Class that writes out all java files under a start directory
 */
public class PrintJavaMain {

    public static void main(String[] args) {
        try {
            //Sets the start file
            File startDirectory = new File("C:\\Users\\Michaels\\IdeaProjects\\1DV507\\src");
            //if that file exists run the method else error message
            if (startDirectory.exists())
                printAllJavaFiles(startDirectory);
            else
                System.out.println("The directory does not exist.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {

        }
    }

    //counter for the depth of the directory
    private static int indent = 1;

    /**
     * Recursive method to toArray out all .java files. if the file is a directory move done that catalog
     * @param start start file as input
     * @throws IOException
     */
    private static void printAllJavaFiles(File start) throws IOException {
        //add all files to a list
        File[] files = start.listFiles();
        //for all files in that list check that file
        for (File f : files) {
            //if directory go in to that and check all files in that
            if (f.isDirectory()) {
                printFile(f);
                indent++;
                printAllJavaFiles(f);
            }
            //if its a file check if it ends with .java, if so we toArray it out
            else if (f.isFile()) {
                if (f.getName().endsWith(".java")) {
                    printFile(f);

                }
            }
        }
        indent--;

    }

    /**
     * Method to toArray a file
     * @param file file to toArray
     * @throws IOException
     */
    private static void printFile(File file) throws IOException {
        StringBuilder print = new StringBuilder();
        //adding indent for how deep in directory we are.
        for (int i = 0; i < indent; i++) {
            print.append("  ");
        }
        //if file ends with .java toArray it out we number of rows in the file, else just toArray the file name
        if (file.getName().endsWith(".java"))
            System.out.println(print.toString() + file.getName() + "size = " + numberOfRows(file) + " rows");
        else
            System.out.println(print.toString() + file.getName());

    }

    /**
     * Method to count rows in .java file.
     * @param file file to read from.
     * @return number of rows in file
     * @throws IOException
     */
    private static int numberOfRows(File file) throws IOException {
        //fileReader to read from file
        FileReader fileReader = new FileReader(file);
        //LineNumberReader take the reader and reads the rows
        LineNumberReader rowsReader = new LineNumberReader(fileReader);
        //counter
        int rows = 0;
        //while LineNumberReader has a row thats not null add one to counter
        while (rowsReader.readLine() != null)
            rows++;
        fileReader.close();
        rowsReader.close();
        return rows;
    }
}
