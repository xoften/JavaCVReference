package mj223gn_assign1;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-27.
 */
public class PrintJavaMain {

    public static void main(String[] args) {
            try {
                File startDirectory = new File("C:\\Users\\Michael\\IdeaProjects\\1DV507");
                if(startDirectory.exists())
                    printAllJavaFiles(startDirectory);
                else
                    System.out.println("The directory does not exist.");
            }
            catch (FileNotFoundException e){
                System.out.println("File not found!");
            }
            catch (IOException e){
                System.out.println("fel");
            }


    }


    //private static int indent = 1, count = 0;
    public static void printAllJavaFiles(File start) throws IOException{
        File[] files = start.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(".java")){
                  //  int rows = numberOfRows(f);
                    System.out.println(f.getName() + " size = " + numberOfRows(f) + " rows");
                }
            } else if (f.isDirectory()) {
                // System.out.println(f.getName());
                printAllJavaFiles(f);
            }

        }

    }
    private static int numberOfRows(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        LineNumberReader rowsReader = new LineNumberReader(fileReader);
        int rows = 0;
        while(rowsReader.readLine() !=null)
            rows++;
        return rows;
    }
}
