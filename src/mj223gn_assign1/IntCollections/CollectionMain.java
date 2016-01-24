package mj223gn_assign1.IntCollections;

/**
 * Created by Michael on 2016-01-19.
 */
public class CollectionMain {

    public static void main(String[] args) {

        System.out.println("List");
        System.out.println();

        ArrayIntList list = new ArrayIntList();

        System.out.println("Is the list empty?: " +list.isEmpty());

        list.add(17);
        list.add(55);
        list.add(100);
        list.add(6);
        list.add(16);
        list.add(78);
        list.add(92);
        list.add(26);

        System.out.println("Is the list empty?: " +list.isEmpty());
        System.out.println("The size of the list is " +list.size() + " elements.");

        list.add(99);

        System.out.println("The size of the list is " +list.size() + " elements.");
        System.out.println(list.toString());

        list.addAt(10, 2);

        System.out.println(list.toString());

        list.remove(1);

        System.out.println(list.toString());

        System.out.println("Element of index 2 is " +list.get(2));

        System.out.println("The element 6 is at index: " +list.indexOf(6));


        System.out.println();
        System.out.println("Stack");
        System.out.println();

        ArrayIntStack stack = new ArrayIntStack();
        stack.pop();
        stack.peek();

        stack.push(5);
        stack.push(100);
        stack.push(56);
        stack.push(49);
        stack.push(4);
        stack.push(78);
        stack.push(32);
        stack.push(67);
        stack.push(12);
        stack.push(55);
        stack.push(198);
        stack.push(523);

        System.out.println();
        System.out.println("The stack contains " +stack.size() +" elements");

        System.out.println("We pop out the last element, the element is: " +stack.pop());
        System.out.println("We pop out the last element, the element is: " +stack.pop());
        System.out.println("We pop out the last element, the element is: " +stack.pop());
        System.out.println("We pop out the last element, the element is: " +stack.pop());

    }
}
