package mj223gn_assign4.BinaryHeap;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-09.
 */
public class test {

    public static void main(String[] args) {
        BinaryIntHeap bih = new BinaryIntHeap();

        bih.insert(12);
        bih.insert(2);
        bih.insert(7);
        bih.insert(8);
        bih.insert(1);
        bih.insert(21);
        bih.insert(4);

        System.out.println("Size of our heap is: "+bih.size());

        System.out.println(bih.toString());

        System.out.println(bih.pullHighest());

        System.out.println("Size of our heap is: "+bih.size());

        System.out.println(bih.toString());

    }
}
