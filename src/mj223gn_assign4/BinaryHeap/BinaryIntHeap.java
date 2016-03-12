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
     * private method that bubble up the inserted value to its spot i the heap.
     */
    private void percolationUp() {
        //index of the inserted element
        int index = size;
        //variable to store the element while we swap places
        int temp;
        //the index we want to swap with
        int parent;
        //while the inserted value is larger then its parent and the index is larger then the first position of the heap.
        while (binaryHeap[index] > binaryHeap[calculateParent(index)] && index > 1) {
            //swap places with the parent
            temp = binaryHeap[index];
            //call the method to calculate the parent index.
            parent = calculateParent(index);
            binaryHeap[index] = binaryHeap[parent];
            binaryHeap[parent] = temp;
            //update the index between iterations
            index = parent;
        }
    }

    /**
     * private method to move an element down the heap.
     */
    private void percolationDown() {
        //start at our first index
        int index = 1;
        //variable to store right child value
        int rightChild;
        //variable to store left child value
        int leftChild;
        //variable to store our element between swaps
        int temp;
        //set the last element at the top of the heap
        binaryHeap[index] = binaryHeap[size];
        //sets the last element to zero
        binaryHeap[size] = 0;
        //reduce the size by one
        size--;

        //While left child is not out of bound and the element at index i smaller the either its left or right child,
        //we change the positions of the largest child and the parent.
        //"very long ugly loop head..."
        while (calculateLeft(index) <= binaryHeap.length && (binaryHeap[index] < binaryHeap[calculateLeft(index)] || binaryHeap[index] < binaryHeap[calculateRight(index)])) {
            //we calculate the children indexes
            rightChild = calculateRight(index);
            leftChild = calculateLeft(index);

            //if the left child is the largest of the child we swap the left child and the parent else the right child.
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
