package mj223gn_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TreeSet class from the interface WordSet
 * Created by Michaels on 2016-02-26.
 */
public class TreeWordSet implements WordSet {

    //size of tree
    private int size;
    //root node
    private Node start;

    /**
     * Constructor of our treeSet
     */
    public TreeWordSet() {

        size = 0;
        start = null;

    }

    /**
     * Recursive method to add a Word to the treeSet
     * @param word to add
     */
    @Override
    public void add(Word word) {
        if (start == null) {
            start = new Node(word);
            size++;
        } else {
            start.add(word);
        }
    }

    /**
     * Check if a word is in the tree
     * @param word to check against
     * @return true if tree contains the word, else false
     */
    @Override
    public boolean contains(Word word) {
        if(start == null) {
            throw new NoSuchElementException();
        }
        return start.contains(word);
    }

    /**
     * Returns the size of tree
     * @return size of tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Constructs an iterator and constructs our array of the tree
     * @return an iterator
     */
    @Override
    public Iterator iterator() {
        return new iterator();
    }
    /**
     * To String method that uses iterator to go through the set
     * @return a String of the set
     */
    @Override
    public String toString(){
        Iterator itr = this.iterator();

        String out = "The elements in this TreeSet is: \n";
        if(size == 0)
            out = "The TreeSet is empty!";
        else{
            while(itr.hasNext()){
                out += itr.next() + "\n";
            }
        }
        return out;
    }

    /**
     * Private inner class Node that contains the words
     */
    private class Node {
        private Word word;
        private Node left;
        private Node right;

        /**
         * Construct a node
         * @param w word to include in the node
         */
        public Node(Word w) {
            word = w;
            left = null;
            right = null;
        }

        /**
         * Recursive method add that adds the word when the method comes to and null node.
         * @param w word to add.
         */
        public void add(Word w) {
            //if the word is less the current word we check the left, if the word is equal we dont add it.
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
        /**
         * Method to check if the word is in our tree
         * @param w word to check
         * @return true if its in the tree, else false
         */
        public boolean contains(Word w) {
            //we check the word against the word at start. if less we go left else right
            //only when we come to a word that is 0 compareTo our word we return true
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

    }

    /**
     * our iterator class that iterates though our array.
     */
    private class iterator implements Iterator {

        //array of tree
        private Word[] array;
        //index of array
        private int index;

        //when we create an iterator we create a new array where we put in all elements
        //in the tree
        public iterator(){
            array = new Word[size];
            index = 0;

            if(size != 0) {
                this.toArray(start);
            }
            index = 0;
        }

        /**
         * Method to input all elements to an array so we can iterate over them
         * @param node start node.
         */
        public void toArray(Node node) {
            //go to the most left then add the word.
            if (node.left != null) {
                this.toArray(node.left);
            }
            array[index++] = node.word;
            if (node.right != null) {
                this.toArray(node.right);
            }
        }

        @Override
        public boolean hasNext() {
            return index != array.length;
        }

        @Override
        public String next() {
            String out = array[index++].toString();
            return out;
        }
    }



}