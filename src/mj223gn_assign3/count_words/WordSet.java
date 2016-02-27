package mj223gn_assign3.count_words;



/**
 * Interface for WordSet
 * Created by Michael Johansson(mj223gn) on 2016-02-25.
 */
public interface WordSet extends Iterable {
    /**
     * method to add a word to a set
     * @param word to add
     */
    void add(Word word);

    /**
     * method to check if the set contains a word
     * @param word to check against
     * @return true if in the set, else false
     */
    boolean contains(Word word);

    /**
     * method to return the current size of the set
     * @return size of set
     */
    int size();

    /**
     * method to print out String in Word
     * @return string of contained words
     */
    String toString();

}
