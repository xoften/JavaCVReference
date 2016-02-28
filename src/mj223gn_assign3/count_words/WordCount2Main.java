package mj223gn_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Michaels on 2016-02-28.
 */
public class WordCount2Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashWordSet hashSet = new HashWordSet();
        TreeWordSet treeSet = new TreeWordSet();

        File file = new File(args[0]);
        Scanner reader = new Scanner(file);

        while (reader.hasNext()) {
            Word word = new Word(reader.next());
            hashSet.add(word);
            treeSet.add(word);
        }

        reader.close();
        System.out.println("The size of the hashSet is: " + hashSet.size());
        System.out.println("The size of the treeSet is: " + treeSet.size());

        System.out.println();
        System.out.println("We iterate over the treeSet: ");
        Iterator tree = treeSet.iterator();
        while (tree.hasNext())
            System.out.println(tree.next());

    }
}
