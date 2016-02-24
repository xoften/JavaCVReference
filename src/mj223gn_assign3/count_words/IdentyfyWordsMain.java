package mj223gn_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-18.
 */
public class IdentyfyWordsMain {

    public static void main(String[] args) {

        File file = new File(args[0]);

        try {
            Scanner reader = new Scanner(file);
            PrintWriter writer = new PrintWriter("C:\\temp\\words.txt");

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
