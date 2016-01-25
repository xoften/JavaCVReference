package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Bicycle extends Vehicle {

    private final int MAX_NUMBER_OF_PASSENGERS = 1;

public Bicycle(){
    super.setVehicleType("Bicycle");
    super.setMaxNumberOfPassengers(MAX_NUMBER_OF_PASSENGERS);
    super.setNumberOfPassengers(1);



}
}
