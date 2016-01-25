package mj223gn_assign1.Ferry;

import java.util.ArrayList;

/**
 * Created by Michael on 2016-01-20.
 */
public class Bicycle extends Vehicle {

    private final int MAX_PASSENGERS = 1;

    public Bicycle() {

        super.setVehicleType("Bicycle");
        super.setMaxNumberOfPassengers(MAX_PASSENGERS);
        super.setNumberOfPassengers(1);


    }
}
