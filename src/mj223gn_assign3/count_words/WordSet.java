package mj223gn_assign3.count_words;



/**
 * Created by Michael Johansson(mj223gn) on 2016-02-25.
 */
public interface WordSet extends Iterable {

    void add(Word word); //Add word if not already added
    boolean contains(Word word); //Return true if word contained
    int size(); //Return the current set size
    String toString(); //Print contained words

}
