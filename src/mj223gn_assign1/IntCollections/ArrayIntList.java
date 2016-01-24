package mj223gn_assign1.IntCollections;

/**
 * Created by Michael on 2016-01-19.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

    @Override
    public void add(int n) {
        if(values.length == size()){
            resize();
        }
        values[size()] = n;
        size++;

    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException  {
        size++;
        for(int i = size(); i >= index; i--){
            values[i+1]=values[i];
        }
        values[index] = n;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
         for(int i = index; i < size(); i++){
            values[i]=values[i+1];
        }
        size--;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        return values[index];
    }

    @Override
    public int indexOf(int n) {
        for(int i = 0; i < size(); i++){
            if(values[i] == n){
                return i;
            }
        }
        return -1;
    }
}
