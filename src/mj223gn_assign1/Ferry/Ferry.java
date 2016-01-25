package mj223gn_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael on 2016-01-20.
 */
public class Ferry implements FerryInterface {

    private int moneyEarned;
    private int spaceTakenOnFerry;
    private int numberOfPassengers;
    private final int MAX_PASSENGERS = 200;
    private final int MAX_SPACE = 200;
    private final int MONEY_LORRY = 300;
    private final int MONEY_BUS = 200;
    private final int MONEY_CAR = 100;
    private final int MONEY_BICYCLE = 40;
    private ArrayList<Passenger> passengersWithNoVehicle;
    private ArrayList<Vehicle> vehiclesOnFerry;

    public Ferry() {
        spaceTakenOnFerry = 0;
        numberOfPassengers = 0;

        ArrayList<Passenger> ps = new ArrayList<Passenger>();
        passengersWithNoVehicle = ps;

        ArrayList<Vehicle> vh = new ArrayList<Vehicle>();
        vehiclesOnFerry = vh;
    }

    @Override
    public int countPassengers() {

        return numberOfPassengers;
    }

    @Override
    public int countVehicleSpace() {

        return spaceTakenOnFerry;
    }

    @Override
    public int countMoney() {
        return moneyEarned;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator(vehiclesOnFerry, vehiclesOnFerry.size());
    }

    @Override
    public void embark(Vehicle v) {
        if (!vehiclesOnFerry.contains(v))
            if (this.hasSpaceFor(v)) {
                vehiclesOnFerry.add(v);
                numberOfPassengers += v.getNumberOfPassengers();
                spaceTakenOnFerry += v.getSpaceNeeded();
                if (v.getVehicleType().equals("Bicycle"))
                    moneyEarned += MONEY_BICYCLE;
                else if (v.getVehicleType().equals("Car"))
                    moneyEarned += MONEY_CAR + (15 * v.getNumberOfPassengers());
                else if (v.getVehicleType().equals("Bus"))
                    moneyEarned += MONEY_BUS + (10 * v.getNumberOfPassengers());
                else if (v.getVehicleType().equals("Lorry"))
                    moneyEarned += MONEY_LORRY + (15 * v.getNumberOfPassengers());
            } else
                System.out.println("There is no space for this " + v.getVehicleType());
        else
            System.out.println("You cant embark the same " + v.getVehicleType());
    }

    @Override
    public void embark(Passenger p) {
        if (hasRoomFor(p)) {
            passengersWithNoVehicle.add(p);
            numberOfPassengers++;
            moneyEarned += 20;
        } else
            System.out.println("There is no room for this passenger");
    }

    @Override
    public void disembark() {
        for (int i = passengersWithNoVehicle.size() - 1; i >= 0; i--) {
            System.out.println("Passenger disembarked from ferry");
            passengersWithNoVehicle.remove(i);
            numberOfPassengers--;

        }
        for (int i = vehiclesOnFerry.size() - 1; i >= 0; i--) {
            System.out.println(vehiclesOnFerry.get(i).getVehicleType() + " disembarked from ferry");
            numberOfPassengers -= vehiclesOnFerry.get(i).getNumberOfPassengers();
            spaceTakenOnFerry -= vehiclesOnFerry.get(i).getSpaceNeeded();
            vehiclesOnFerry.remove(i);


        }
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        if ((spaceTakenOnFerry + v.getSpaceNeeded()) < MAX_SPACE && (numberOfPassengers + v.getNumberOfPassengers()) < MAX_PASSENGERS)
            return true;
        else
            return false;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        if (passengersWithNoVehicle.size() < MAX_PASSENGERS)
            return true;
        else
            return false;
    }

}
