package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Car extends Vehicle {

    private final int MAX_PASSENGERS = 4;

    public Car(int n) {

        super.setVehicleType("Car");
        super.setMaxNumberOfPassengers(MAX_PASSENGERS);
        super.setNumberOfPassengers(n);


    }

}
