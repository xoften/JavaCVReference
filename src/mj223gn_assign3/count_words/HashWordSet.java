package mj223gn_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private class iterator implements Iterator{

        private int index;
        private Node node;

        public iterator(){

            node = null;
            index = -1;
        }

        @Override
        public boolean hasNext() {
            if(node != null && node.next != null){
                return true;
            }
            for (int i = index + 1; i < buckets.length; i++){
                if (buckets[i] != null){
                    return true;
                }
            }

            return false;
        }

        @Override
        public String next() {

            if(node != null && node.next != null){
                node = node.next;
            }
            else{
                do {
                    index++;
                    if (index == buckets.length) {
                        throw new NoSuchElementException();
                    }
                    node = buckets[index];
                }
                while(node == null);
            }
            return node.stringWord;
        }
    }
}
