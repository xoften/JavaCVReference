package mj223gn_assign3.count_words;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-24.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String string) {
        word = string;
    }

    public String toString() {
        return this.word;
    }

    @Override
    public int hashCode() {
        if (word.toLowerCase().hashCode() < 0)
            return -1 * word.toLowerCase().hashCode();
        else
            return word.toLowerCase().hashCode();
    }

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

    @Override
    public int compareTo(Word w) {
        return this.word.compareToIgnoreCase(w.word);
    }
}