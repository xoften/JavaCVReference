package mj223gn_assign1.LanguageTool;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michaels on 2016-01-30.
 */
public class FileReader {

    private ArrayList<String> rows;

    public FileReader(File file) throws IOException{
        rows = new ArrayList<>();
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            rows.add(input.nextLine());
        }

    }
    public void proofRead() throws IOException{
        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());

        for (int i = 0; i < rows.size(); i++) {
            List<RuleMatch> match = langTool.check(rows.get(i));
            System.out.println("Errors at line " + (i+1) +": ");
            System.out.println("--------------------------------------");
            for (RuleMatch matches: match) {

                System.out.println("\tError starts at Char " + matches.getColumn()+": "+ matches.getMessage());
                System.out.println("\tSuggested change: "+ matches.getSuggestedReplacements());
                System.out.println();

            }
        }
    }

}
