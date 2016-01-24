package mj223gn_assign1.IntCollections;

/**
 * Created by Michael on 2016-01-20.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    /**
     * Method to add a integer to the stack
     * @param n integer to add
     */
    @Override
    public void push(int n) {
        if(values.length == size()){
            resize();
        }
        values[size] = n;
        size++;
    }

    /**
     * Method to remove a integer from stack
     * @return the integer that got removed
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        size--;
        return values[size];
    }

    /**
     * Method to peek at the top integer in the stack
     * @return top integer in stack
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        return values[size];
    }
}
