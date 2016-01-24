package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Lorry extends Vehicle {

    public Lorry(int n){
        super.setVehicleType("Lorry");
        super.setMaxNumberOfPassengers(2);
        super.setNumberOfPassengers(n);
        super.setSpaceNeeded(40);


    }




}
