package mj223gn_assign1;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Michael Johansson(mj223gn) on 2016-01-29.
 */
public class LanguageToolMain {

    public static void main(String[] args) throws IOException {
        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());


        String testInput = "A sentence with a error in the Hitchhiker’s Guide tot he Galaxy";
        List<RuleMatch> matches = langTool.check(testInput);
        for (RuleMatch match : matches) {
            System.out.println("Potential error at line " +
                    match.getLine() + ", column " +
                    match.getColumn() + ": " + match.getMessage());
            System.out.println("Suggested correction: " +
                    match.getSuggestedReplacements());
        }
    }
}
