package mj223gn_assign4.BinaryHeap;

import java.util.NoSuchElementException;

/**
 * binaryIntHeap class, array based
 * Created by Michael Johansson(mj223gn) on 2016-03-09.
 */
public class BinaryIntHeap {

    private int[] binaryHeap;
    private int size;

    /**
     * constructs a new array with length 10
     */
    public BinaryIntHeap() {

        binaryHeap = new int[10];
        size = 0;

    }

    /**
     * Insert a Integer into the array at the position of the last element.
     * Then call percolationUp to check if the value is larger the its parent, if so change position.
     * @param n Integer to add to heap
     */
    public void insert(int n) {
        if (isEmpty()) {
            binaryHeap[++size] = n;
        } else {
            //if size + 1 is as much as length of array we have to resize the array
            if (size + 1 == binaryHeap.length) {
                resize();
            }
            binaryHeap[++size] = n;
            percolationUp();
        }
    }

    /**
     * Remove and return the highest value in the heap.
     * Calls the method percolationDown to go through the tree and fix the priority.
     * @return the highest value in heap
     */
    public int pullHighest() {
        if(isEmpty()){
            throw new NoSuchElementException("Heap is empty");
        }
        int highest = binaryHeap[1];
        percolationDown();
        return highest;
    }

    /**
     * Gives the current size of the heap
     * @return size of heap
     */
    public int size() {
        return size;
    }

    /**
     * Check the heap if its empty or not
     * @return true if heap is empty else false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * toString method to write out the array.
     * made in test purpose
     * @return array as string
     */
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= size; i++){
            out.append(binaryHeap[i]);
            out.append(", ");
        }
        return "[" + out.toString().substring(0,out.length()-2) + "]";
    }
    /**
     * Private method to resize the array if the elements in the heap get as long as the array length.
     * doubles the current length.
     */
    private void resize() {
        int[] temp = new int[binaryHeap.length * 2];
        for (int i = 0; i < binaryHeap.length; i++) {
            temp[i] = binaryHeap[i];
        }
        binaryHeap = temp;
    }

    /**
     * private method to calculate the parent index
     * @param index of the child
     * @return index of the parent
     */
    private int calculateParent(int index){
        return index/2;
    }

    /**
     * private method to calculate the left child index
     * @param index of the parent
     * @return index of the left child
     */
    private int calculateLeft(int index){
        return 2*index;
    }

    /**
     * private method to calculate the right child index
     * @param index of the parent
     * @return index of the right child
     */
    private int calculateRight(int index){
        return 2*index+1;
    }

    /**
     *
     */
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

    /**
     *
     */
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
