package mj223gn_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Program to read from one file and write all words and whitespaces to another file.
 * removing all that is not a letter or whitespace.
 * Created by Michael Johansson(mj223gn) on 2016-02-18.
 */
public class IdentyfyWordsMain {

    public static void main(String[] args) {

        //take file to read from as an argument to the program
        File file = new File(args[0]);

        try {
            Scanner reader = new Scanner(file);
            //write to the file words.txt
            PrintWriter writer = new PrintWriter("C:\\temp\\words.txt");

            //while there is a line in the file we read it and take out the letters and whitespaces
            //and writes them to words.txt
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char next = line.charAt(i);
                    if (Character.isLetter(next)) {
                        writer.print(next);
                    } else if (Character.isWhitespace(next)) {
                        writer.print(next);
                    }
                }
                //if we have a line that is larger then 0 we write out a return if the line is zero long
                //we skip adding the return
                if(line.length() != 0)
                    writer.println();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

    }
}
