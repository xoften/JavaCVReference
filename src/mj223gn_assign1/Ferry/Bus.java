package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Bus extends Vehicle {

    private final int SPACE_NEEDED = 20;

    public Bus(int n){
        super.setVehicleType("Bus");
        super.setMaxNumberOfPassengers(20);
        super.setNumberOfPassengers(n);
        super.setSpaceNeeded(SPACE_NEEDED);

    }
}
