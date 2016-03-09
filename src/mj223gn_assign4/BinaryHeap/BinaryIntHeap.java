package mj223gn_assign4.BinaryHeap;


/**
 * Created by Michael Johansson(mj223gn) on 2016-03-09.
 */
public class BinaryIntHeap {

    private Node[] binaryHeap;
    private int size;
    private int last;

    public BinaryIntHeap(){

        binaryHeap = new Node[10];
        size = 0;
        last = 1;

    }
    public void insert(int n) {
        binaryHeap[last] = new Node(n);
        last++;
        percolationUp();
        if(last == binaryHeap.length){
            resize();
        }
    }
    public int pullHighest(){
        return 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void resize(){

    }
    private void percolationUp(){
        while(binaryHeap[last].value > binaryHeap[last/2].value && last/2 != 1){
            Node temp = binaryHeap[last/2];
            binaryHeap[last/2] = binaryHeap[last];
            binaryHeap[last] = temp;
        }
    }
    private class Node{

        private int value;

        public Node(int n){
            this.value = n;
        }
    }
}
