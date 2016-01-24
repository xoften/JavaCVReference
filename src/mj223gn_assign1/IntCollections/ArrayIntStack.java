package mj223gn_assign1.IntCollections;

/**
 * Created by Michael on 2016-01-20.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    @Override
    public void push(int n) {
        if(values.length == size()){
            resize();
        }
        values[size] = n;
        size++;
    }

    @Override
    public int pop() throws IndexOutOfBoundsException {
        size--;
        int last = values[size];
        return last;
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        return values[size];
    }
}
