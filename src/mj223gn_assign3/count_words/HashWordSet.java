package mj223gn_assign3.count_words;

import java.util.Iterator;

/**
 * Created by Michael Johansson(mj223gn) on 2016-02-25.
 */
public class HashWordSet implements WordSet {

    private Node[] buckets;
    private int size;

    public HashWordSet(){
        buckets = new Node[10];
        size = 0;
    }

    @Override
    public void add(Word w) {
        int hashKey = w.hashCode() % buckets.length;
        Node node = buckets[hashKey];
        while(node != null){
            if(node.stringWord.equals(w.toString())){
                return;
            }
            else node = node.next;
        }
        node = new Node(w);
        node.next = buckets[hashKey];
        buckets[hashKey] = node;
        size++;
        if(size == buckets.length)
            rehash();
    }

    public void rehash(){
        System.out.println("rehashing");
        Node[] temp = buckets;
        buckets = new Node[2*temp.length];
        size = 0;
        for (Node node : temp){
            if(node != null){
                while(node != null) {
                add(node.word);
                node = node.next;
                }
            }
        }
    }

    @Override
    public boolean contains(Word w) {
        int hash = w.hashCode() % buckets.length;
        Node node = buckets[hash];
        while(node != null){
            if(node.stringWord.equals(w.toString())){
                return true;
            }
            else
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

    public class Node{

        private Word word;
        private String stringWord;
        private Node next;

        public Node(Word w){
            word = w;
            stringWord = w.toString();
        }
    }
    private class iterator implements Iterator<Word>{

        int index = 0;
        Node node = buckets[index];

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            while (index < size){
                return true;
            }

            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Word next() {
            Word word = node.word;

            if(node.next == null){

                index++;

            }
            else {
                node = node.next;
            }
            return word;
        }
    }
}
