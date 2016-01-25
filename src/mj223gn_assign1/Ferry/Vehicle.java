package mj223gn_assign1.Ferry;

import java.util.ArrayList;

/**
 * Created by Michael on 2016-01-20.
 */
public abstract class Vehicle {

    private String vehicleType;
    private int numberOfPassengers;
    private int maxNumberOfPassengers;
    private ArrayList<Passenger> passengers = new ArrayList<>();


    public void setVehicleType(String type) {
        vehicleType = type;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setMaxNumberOfPassengers(int n) {
        maxNumberOfPassengers = n;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public void setNumberOfPassengers(int n) {
        for (int i = 0; i < n; i++) {
            if (passengers.size() < maxNumberOfPassengers) {
                passengers.add(new Passenger());
                numberOfPassengers++;
            } else
                System.err.println("Cant add more Passengers to this " + vehicleType);
        }
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

}
