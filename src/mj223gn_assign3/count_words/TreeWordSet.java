package mj223gn_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Michaels on 2016-02-26.
 */
public class TreeWordSet implements WordSet {

    private int size;
    private Node start;

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
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return null;
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
            if (word.compareTo(w) < 0) {
                if (left == null) {
                    left = new Node(w);
                    size++;
                } else {
                    left.add(w);
                }
            } else if (word.compareTo(w) > 0) {
                if (right == null) {
                    right = new Node(w);
                    size++;
                } else {
                    right.add(w);
                }
            }

        }
        private class iterator implements Iterator{

            private Node node;

            public iterator(){
                node = start;

            }

            @Override
            public boolean hasNext() {
                return (node != null);
            }
            @Override
            public Object next() {
                String out = "";
                if(node == null){
                    throw new NoSuchElementException();
                }
                out = node.word.toString();
                if (node.left != null){
                    node = node.left;
                }
                else if(node.right != null){
                    node = node.right;
                }
                else {
                    Node parent = node.p
                }
            }
        }


    }
}
