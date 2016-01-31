package mj223gn_assign1.LanguageTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 * Main to run our class filereader. we take in a file as an argument
 */
public class LanguageToolMain {

    public static void main(String[] args) throws IOException {
        try {
            File file = new File(args[0]);

            FileReader readFile = new FileReader(file);

            System.out.println(readFile.proofRead());
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e){

        }
    }
}
