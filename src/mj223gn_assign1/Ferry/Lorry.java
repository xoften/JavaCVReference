package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Lorry extends Vehicle {

    private final int MAX_PASSENGERS = 2;

    public Lorry(int n){
        super.setVehicleType("Lorry");
        super.setMaxNumberOfPassengers(MAX_PASSENGERS);
        super.setNumberOfPassengers(n);



    }




}
