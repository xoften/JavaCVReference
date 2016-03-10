package mj223gn_assign4.BinaryHeap;


import java.util.Arrays;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-09.
 */
public class BinaryIntHeap {

    private int[] binaryHeap;
    private int size;

    public BinaryIntHeap(){

        binaryHeap = new int[10];
        size = 0;

    }
    public void insert(int n) {
        if(isEmpty()){
            binaryHeap[++size] = n;
        }
        else{
            binaryHeap[++size] = n;
            percolationUp();
            if(size+1 == binaryHeap.length){
                resize();
            }
        }


    }
    public int pullHighest(){
        int highest = binaryHeap[1];
        percolationDown();
        return highest;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void resize(){
        int[] temp = new int[binaryHeap.length*2];
        for (int i = 0; i < binaryHeap.length; i++){
            temp[i] = binaryHeap[i];
        }
        binaryHeap = temp;
    }
    public String toString(){
        return Arrays.toString(this.binaryHeap);
    }
    private void percolationUp(){
        int index = size;
        while(binaryHeap[index] > binaryHeap[index/2] && index > 1){
            int temp = binaryHeap[index];
            binaryHeap[index] = binaryHeap[index/2];
            binaryHeap[index/2] = temp;
            index = index/2;
        }
    }
    private void percolationDown(){
        int index = 1;
        binaryHeap[index] = binaryHeap[size];
        binaryHeap[size] = 0;
        while (binaryHeap[2*index] > binaryHeap[2*index+1]){
            if(binaryHeap[2*index] > binaryHeap[index]){
                System.out.println("kalle");
                int temp = binaryHeap[index];
                binaryHeap[index] = binaryHeap[2*index];
                binaryHeap[2*index] = temp;
                index = 2*index;
            }
            else if (binaryHeap[2 * index + 1] > binaryHeap[index]) {
                System.out.println("patrik");
                int temp = binaryHeap[index];
                binaryHeap[index] = binaryHeap[2 * index];
                binaryHeap[2 * index] = temp;
                index = 2*index+1;
            }
        }
        while (binaryHeap[2*index] < binaryHeap[2*index+1]) {
            if (binaryHeap[2 * index + 1] > binaryHeap[index]) {
                System.out.println("Michael");
                int temp = binaryHeap[index];
                binaryHeap[index] = binaryHeap[2 * index];
                binaryHeap[2 * index] = temp;
                index = 2*index+1;
            }
            else if(binaryHeap[2*index] > binaryHeap[index]){
                System.out.println("bajs");
                int temp = binaryHeap[index];
                binaryHeap[index] = binaryHeap[2*index];
                binaryHeap[2*index] = temp;
                index = 2*index;
            }
        }
    }
}
