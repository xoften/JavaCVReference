package mj223gn_assign1.LanguageTool;


import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michaels on 2016-01-30.
 * Class FileReader that reads in a file and line by line put then into an list.
 * then a couple of methods to use one the fileReader.
 */
public class FileReader {

    private ArrayList<String> rows;
    private File file;

    /**
     * Constructor for the class
     * @param f take a file as input.
     * @throws IOException
     */
    public FileReader(File f) throws IOException{
        rows = new ArrayList<>();
        file = f;
        //Scan the file while the file has next line add it to the list.
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            rows.add(input.nextLine());
        }
        input.close();

    }

    /**
     * Method that proofread the text with the help of the languageTool.
     * @return String with the errors
     * @throws IOException
     */
    public String proofRead() throws IOException{
        //create a new object of languageTool.
        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());

        StringBuilder sb = new StringBuilder();
        //for each row i the list we check that row for errors.
        for (int i = 0; i < rows.size(); i++) {
            List<RuleMatch> match = langTool.check(rows.get(i));
            //if the list of errors is larger then 0 we write out the row number to our stringBuilder.
            if(match.size() > 0) {
                sb.append("Errors at line " + (i + 1) + "\n");
                sb.append("--------------------------------------\n");
                //for every error we write them to our StringBuilder
                for (RuleMatch matches : match) {

                    sb.append("\tError starts at Char " + matches.getColumn() + ": " + matches.getMessage() + "\n");
                    sb.append("\tSuggested change: " + matches.getSuggestedReplacements() + "\n\n");

                }
            }
        }
        //then we make the stringbuilder to a string and return it
        return sb.toString();
    }

    /**
     * Method to write out the file
     * @param file file that we want to read from.
     * @return String of the file
     * @throws IOException
     */
    public String printFile(File file) throws IOException {

        BufferedReader br = new BufferedReader(new java.io.FileReader(file));

            StringBuilder sb = new StringBuilder();
            String nextLine = br.readLine();

            while (nextLine != null) {
                sb.append(nextLine + "\n");
                nextLine = br.readLine();
            }
            br.close();
            return sb.toString();
        }


    }




