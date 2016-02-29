package mj223gn_assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * We use our own treeWordSet and hashWordSet on our words.txt
 * Created by Michaels on 2016-02-28.
 */
public class WordCount2Main {

    public static void main(String[] args) throws FileNotFoundException {

        //set up som Sets
        HashWordSet hashSet = new HashWordSet();
        TreeWordSet treeSet = new TreeWordSet();
        TreeWordSet test = new TreeWordSet();
        HashWordSet test2 = new HashWordSet();

        //Take in a file as argument
        File file = new File(args[0]);
        Scanner reader = new Scanner(file);

        while (reader.hasNext()) {
            Word word = new Word(reader.next());
            hashSet.add(word);
            treeSet.add(word);
        }

        reader.close();


        System.out.println("Se if both set contains 'a': " +hashSet.contains(new Word("a")) + " and " + treeSet.contains(new Word("a")));

        System.out.println("The size of the hashSet is: " + hashSet.size());
        System.out.println("The size of the treeSet is: " + treeSet.size());

        System.out.println(hashSet.toString());
        System.out.println(treeSet.toString());

        //iterate over the tree set
        System.out.println();
        System.out.println("We iterate over the treeSet: ");
        Iterator tree = treeSet.iterator();
        while (tree.hasNext())
            System.out.println(tree.next());

        //test empty sets
        System.out.println("We test so we can write out empty Sets: "+ test.toString());
        System.out.println("We test so we can write out empty Sets: "+ test2.toString());

    }
}
