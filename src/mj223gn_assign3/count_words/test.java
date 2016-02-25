package mj223gn_assign3.count_words;

import java.util.Iterator;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-25.
 */
public class test {

    public static void main(String[] args) {

        HashWordSet set = new HashWordSet();

        set.add(new Word("kapris"));
        set.add(new Word("balle"));
        set.add(new Word("hej"));
        set.add(new Word("då"));
        set.add(new Word("kalle"));
        set.add(new Word("hej"));
        set.add(new Word("då"));
        set.add(new Word("alle"));
        set.add(new Word("ej"));
        set.add(new Word("å"));
        set.add(new Word("kalle"));
        set.add(new Word("ej"));
        set.add(new Word("d"));
        set.add(new Word("kall"));
        System.out.println(set.size());

        System.out.println(set.contains(new Word("hej")));

        Iterator itr = set.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println(set.size());
    }
}
