package mj223gn_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * My implementation of the interface WordSet. This is a hashset implementation.
 * Created by Michael Johansson(mj223gn) on 2016-02-25.
 */
public class HashWordSet implements WordSet {

    //Node array for our buckets
    private Node[] buckets;
    //size of elements in the array
    private int size;

    /**
     * Constructor of a hashWordSet.
     * Start with an array length of 10.
     */
    public HashWordSet() {
        buckets = new Node[10];
        size = 0;
    }

    /**
     * add method to add an word to the hashWordSet.
     *
     * @param w word to add
     */
    @Override
    public void add(Word w) {
        //calculate what bucket to add the word to
        int hashKey = w.hashCode() % buckets.length;
        Node node = buckets[hashKey];
        while (node != null) {
            //if the word at the bucket is equals to w, we skip adding it.
            if (node.word.equals(w)) {
                return;
            }
            //if not equals we go through to the next word in the bucket
            else node = node.next;
        }
        //when we come to a node that is null we add the word to that node
        node = new Node(w);
        node.next = buckets[hashKey];
        buckets[hashKey] = node;
        size++;
        //if the size gets equals to the length of buckets we rehash the bucket array
        if (size == buckets.length)
            rehash();
    }

    /**
     * Method to doubles the size of the buckets
     * recalculates the hashkeys for all items
     */
    public void rehash() {
        Node[] temp = buckets;
        buckets = new Node[2 * temp.length];
        size = 0;
        //for each word in temp we recalculate the new hashkey for all words
        for (Node node : temp) {
            while (node != null) {
                add(node.word);
                node = node.next;
            }
        }
    }

    /**
     * method to check if the hashWordSet contains a specific word
     *
     * @param w word to check if its inside the set
     * @return true if the word is in the hashWordSet, else false
     */
    @Override
    public boolean contains(Word w) {
        int hash = w.hashCode() % buckets.length;
        Node node = buckets[hash];
        while (node != null) {
            if (node.stringWord.equals(w.toString())) {
                return true;
            } else
                node = node.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over elements of type Word.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new iterator();
    }

    /**
     * private inner class node to hold a Word and its contained word.
     * also contains the next node.
     */
    private class Node {

        private Word word;
        private String stringWord;
        private Node next;

        public Node(Word w) {
            word = w;
            stringWord = w.toString();
        }
    }

    private class iterator implements Iterator {

        private int index;
        private Node node;

        public iterator() {

            node = null;
            //start at -1 so our first node gets zero.
            index = -1;
        }

        @Override
        public boolean hasNext() {
            //while node is not null and next node is not null we return true
            if (node != null && node.next != null) {
                return true;
            }
            //if the next node is null we check if there is any bucket later with nodes in it
            for (int i = index + 1; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public String next() {
            //if the node is not null and next is not null we set node to next
            if (node != null && node.next != null) {
                node = node.next;
            }
            //if the node is null we go to next bucket while the node is not null
            else {
                do {
                    index++;
                    if (index == buckets.length) {
                        throw new NoSuchElementException();
                    }
                    node = buckets[index];
                }
                while (node == null);
            }
            return node.stringWord;
        }
    }
}
