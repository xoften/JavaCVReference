package mj223gn_assign4.BinaryHeap;

/**
 * Created by Michael Johansson(mj223gn) on 2016-03-09.
 */
public class test {

    public static void main(String[] args) {
        BinaryIntHeap bih = new BinaryIntHeap();

        bih.insert(10);
        bih.insert(8);
        bih.insert(9);
        bih.insert(13);
        bih.insert(98);
        bih.insert(5);
        bih.insert(76);
        bih.insert(14);
        bih.insert(1);
        System.out.println(bih.size());

        System.out.println(bih.pullHighest());

        System.out.println(bih.toString());

    }
}
