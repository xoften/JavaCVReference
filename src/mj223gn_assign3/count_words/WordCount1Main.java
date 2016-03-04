package mj223gn_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * We use treeSet and hashSet from java library on our words.txt
 * Created by Michael Johansson(mj223gn) on 2016-02-24.
 */
public class WordCount1Main {

    public static void main(String[] args) throws FileNotFoundException {

        Set<Word> hashSet = new HashSet<>();
        Set<Word> treeSet = new TreeSet<>();

        File file = new File(args[0]);
        Scanner reader = new Scanner(file);

        while(reader.hasNext()){
            Word word = new Word(reader.next());
            hashSet.add(word);
            treeSet.add(word);
        }

        reader.close();


        System.out.println("The size of the hashSet is: " +hashSet.size());
        System.out.println("The size of the treeSet is: " +treeSet.size());

        System.out.println();
        System.out.println("We iterate over the treeSet: ");
        Iterator tree = treeSet.iterator();
        while(tree.hasNext())
            System.out.println(tree.next());

    }
}
