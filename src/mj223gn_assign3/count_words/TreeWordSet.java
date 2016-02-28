package mj223gn_assign3.count_words;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-02-26.
 */
public class TreeWordSet implements WordSet {

    private int size;
    private Node start;
    private static Word[] array;
    private static int index = 0;

    public TreeWordSet() {

        size = 0;
        start = null;

    }

    @Override
    public void add(Word word) {
        if (start == null) {
            start = new Node(word);
            size++;
        } else {
            start.add(word);
        }
    }

    @Override
    public boolean contains(Word word) {
            return start.contains(word);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        array = new Word[size];
        start.toArray();
        return new iterator();
    }

    private class Node {
        private Word word;
        private Node left;
        private Node right;

        public Node(Word w) {
            word = w;
            left = null;
            right = null;
        }

        public void add(Word w) {
            if (word.compareTo(w) > 0) {
                if (left == null) {
                    left = new Node(w);
                    size++;
                } else {
                    left.add(w);
                }
            } else if (word.compareTo(w) < 0) {
                if (right == null) {
                    right = new Node(w);
                    size++;
                } else {
                    right.add(w);
                }
            }

        }

        public boolean contains(Word w) {
            if (word.compareTo(w) > 0) {
                if (left == null) {
                    return false;
                } else {
                    left.contains(w);
                }
            }
            else if (word.compareTo(w) < 0) {
                if (right == null) {
                    return false;
                } else {
                    right.contains(w);
                }
            }
            return true;

        }

        public void toArray() {
            if (left != null) {
                left.toArray();
            }
            array[index] = word;
            index++;
            if (right != null) {
                right.toArray();
            }
        }


    }

    private class iterator implements Iterator {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i != array.length;
        }

        @Override
        public String next() {
            String out = array[i].toString();
            i++;
            return out;
        }
    }


}