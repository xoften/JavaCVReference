package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Bus extends Vehicle {

    private final int MAX_PASSENGERS = 20;

    public Bus(int n) {

        super.setVehicleType("Bus");
        super.setMaxNumberOfPassengers(MAX_PASSENGERS);
        super.setNumberOfPassengers(n);

    }
}
