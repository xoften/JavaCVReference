package mj223gn_assign3.count_words;

/**
 * Word class with hash and methods to compare two Words
 * Created by Michael Johansson(mj223gn) on 2016-02-24.
 */
public class Word implements Comparable<Word> {
    private String word;

    /**
     * Construct a new Word
     * @param string takes a string as input
     */
    public Word(String string) {
        word = string;
    }

    /**
     * returns the string stored as input
     * @return word as string
     */
    public String toString() {
        return this.word;
    }

    /**
     * Calculate an hash on the word
     * @return hashcode
     */
    @Override
    public int hashCode() {
        //if hash is to large for an int we get a negative value.
        if (word.toLowerCase().hashCode() < 0)
            //we multiply the hash with -1 to change the hash to positive
            return -1 * word.toLowerCase().hashCode();
        else
            return word.toLowerCase().hashCode();
    }

    /**
     * Method to check if two words is equal, we take in an object and if its a instance of Word we cast it to a word
     * and use our compareTo method to check if they are equal.
     * @param other input Object.
     * @return true if equals, else false
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word otherWord = (Word) other;
            if (this.word.toLowerCase().compareTo(otherWord.word.toLowerCase()) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compare to method to compare two words with ignoreCase so its not case sensitive
     * @param w Word to check against
     * @return 0 if equals, negative if smaller then W, positive if larger then W
     */
    @Override
    public int compareTo(Word w) {
        return this.word.compareToIgnoreCase(w.word);
    }
}