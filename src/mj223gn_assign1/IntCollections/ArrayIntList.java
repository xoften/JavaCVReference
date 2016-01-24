package mj223gn_assign1.IntCollections;

/**
 * Created by Michael on 2016-01-19.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

    /**
     * Method to add a interger to the list
     * @param n interger to add to the list.
     */
    @Override
    public void add(int n) {
        if(values.length == size()){
            resize();
        }
        values[size()] = n;
        size++;

    }

    /**
     * Method to add a integer to a specific index in the list
     * @param n integer to add to list
     * @param index index of the list to add the integer at
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException  {
        if(index > size()){
         resize();
         size = index;
        }
        for(int i = size(); i >= index; i--){
            values[i+1]=values[i];
        }
        values[index] = n;
        size++;
    }

    /**
     * Method to remove one integer from list
     * @param index index of the integer to remove
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
         for(int i = index; i <= size(); i++){
            values[i]=values[i+1];
        }
        size--;
    }

    /**
     * Method to check what integer is at a specific index
     * @param index index to check
     * @return integer at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        return values[index];
    }

    /**
     * Method to check what index a specific integer has
     * @param n integer to check
     * @return index of n, if n is not in the list returns -1
     */
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
