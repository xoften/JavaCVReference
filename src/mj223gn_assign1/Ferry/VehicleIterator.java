package mj223gn_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michaels on 2016-01-21.
 */
public class VehicleIterator implements Iterator<Vehicle> {

    private ArrayList<Vehicle> vehicles;
    private int next;
    private final int SIZE;

    public VehicleIterator(ArrayList<Vehicle> list){
        vehicles = list;
        SIZE = vehicles.size();
    }
    @Override
    public boolean hasNext() {
        return next < SIZE;
    }

    @Override
    public Vehicle next() {
        return vehicles.get(next++);
    }
}
