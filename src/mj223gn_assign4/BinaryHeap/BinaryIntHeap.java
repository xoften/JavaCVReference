package mj223gn_assign4.BinaryHeap;


import java.util.NoSuchElementException;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-09.
 */
public class BinaryIntHeap {

    private int[] binaryHeap;
    private int size;

    public BinaryIntHeap() {

        binaryHeap = new int[10];
        size = 0;

    }

    public void insert(int n) {
        if (isEmpty()) {
            binaryHeap[++size] = n;
        } else {
            if (size + 1 == binaryHeap.length) {
                resize();
            }
            binaryHeap[++size] = n;
            percolationUp();
        }
    }
    public int pullHighest() {
        if(isEmpty()){
            throw new NoSuchElementException("Heap is empty");
        }
        int highest = binaryHeap[1];
        percolationDown();
        return highest;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize() {
        int[] temp = new int[binaryHeap.length * 2];
        for (int i = 0; i < binaryHeap.length; i++) {
            temp[i] = binaryHeap[i];
        }
        binaryHeap = temp;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= size; i++){
            out.append(binaryHeap[i]);
            out.append(", ");
        }
        return "[" + out.toString().substring(0,out.length()-2) + "]";
    }
    private int calculateParent(int index){
        return index/2;
    }
    private int calculateLeft(int index){
        return 2*index;
    }
    private int calculateRight(int index){
        return 2*index+1;
    }

    private void percolationUp() {
        int index = size;
        int temp;
        int parent;
        while (binaryHeap[index] > binaryHeap[calculateParent(index)] && index > 1) {
            temp = binaryHeap[index];
            parent = calculateParent(index);
            binaryHeap[index] = binaryHeap[parent];
            binaryHeap[parent] = temp;
            index = parent;
        }
    }

    private void percolationDown() {
        int index = 1;
        int rightChild;
        int leftChild;
        int temp;
        binaryHeap[index] = binaryHeap[size];
        binaryHeap[size] = 0;
        size--;
        while (calculateRight(index) <= binaryHeap.length && (binaryHeap[index] < binaryHeap[calculateLeft(index)] || binaryHeap[index] < binaryHeap[calculateRight(index)])) {
            rightChild = calculateRight(index);
            leftChild = calculateLeft(index);
            if (binaryHeap[leftChild] > binaryHeap[rightChild]) {
                temp = binaryHeap[index];
                binaryHeap[index] = binaryHeap[leftChild];
                binaryHeap[leftChild] = temp;
                index = leftChild;
            } else if (binaryHeap[leftChild] < binaryHeap[rightChild]) {
                temp = binaryHeap[index];
                binaryHeap[index] = binaryHeap[rightChild];
                binaryHeap[rightChild] = temp;
                index = rightChild;

            }
        }

    }
}
