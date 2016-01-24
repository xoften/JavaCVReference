package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Car extends Vehicle {

    private final int SPACE_NEEDED = 5;

    public Car(int n){
        super.setVehicleType("Car");
        super.setMaxNumberOfPassengers(4);
        super.setNumberOfPassengers(n);
        super.setSpaceNeeded(SPACE_NEEDED);

    }

}
