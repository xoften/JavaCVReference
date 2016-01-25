package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Bus extends Vehicle {


    public Bus(int n){
        super.setVehicleType("Bus");
        super.setMaxNumberOfPassengers(20);
        super.setNumberOfPassengers(n);

    }
}
