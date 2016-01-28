package mj223gn_assign1.Ferry;

/**
 * Created by Michael on 2016-01-20.
 */
public class Passenger {

    private String passenger;
    private static int passengerCode = 1;

    public Passenger(){
        passenger = "Passenger " + passengerCode;
        passengerCode++;
    }

}
