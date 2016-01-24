package mj223gn_assign1.Ferry;

import java.util.ArrayList;

/**
 * Created by Michael on 2016-01-20.
 */
public class Vehicle {

    private String vehicleType;
    private int numberOfPassengers;
    private int maxNumberOfPassengers;
    private int spaceNeeded;
    private ArrayList<Passenger> passengers;


    public Vehicle(){
        vehicleType = "";
        numberOfPassengers = 0;
        maxNumberOfPassengers = 1;
        spaceNeeded = 1;

        ArrayList<Passenger> ps = new ArrayList<Passenger>();
        passengers = ps;
    }
    public void setVehicleType(String type){
        vehicleType = type;
    }
    public String getVehicleType(){
        return vehicleType;
    }
    public void setSpaceNeeded(int n){
        spaceNeeded = n;
    }
    public int getSpaceNeeded(){
        return spaceNeeded;
    }
    public void setMaxNumberOfPassengers(int n){
        maxNumberOfPassengers = n;
    }
    public int getMaxNumberOfPassengers(){
        return maxNumberOfPassengers;
    }
    public void setNumberOfPassengers(int n){
        for (int i = 0; i < n; i++) {
            if (passengers.size() < maxNumberOfPassengers) {
                passengers.add(new Passenger());
                numberOfPassengers++;
            }
            else
                System.err.println("Cant add more Passengers to this " + vehicleType);
        }
    }
    public int getNumberOfPassengers(){
        return numberOfPassengers;
    }
}
