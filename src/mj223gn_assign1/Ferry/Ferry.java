package mj223gn_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael on 2016-01-20.
 */
public class Ferry implements FerryInterface {

    private int moneyEarned;
    private int spaceTakenOnFerry;
    private final int MAX_PASSENGERS = 200;
    private final int MAX_SPACE = 200;
    private final int MONEY_PASSENGER_WALKING_ON = 20;
    private final int MONEY_LORRY = 300;
    private final int MONEY_BUS = 200;
    private final int MONEY_CAR = 100;
    private final int MONEY_BICYCLE = 40;
    private final int BICYCLE_SPACE_TAKEN = 1;
    private final int CAR_SPACE_TAKEN = 5;
    private final int BUS_SPACE_TAKEN = 20;
    private final int LORRY_SPACE_TAKEN = 40;
    private ArrayList<Passenger> passengers;
    private ArrayList<Vehicle> vehiclesOnFerry;

    public Ferry() {
        spaceTakenOnFerry = 0;

        ArrayList<Passenger> ps = new ArrayList<>();
        passengers = ps;

        ArrayList<Vehicle> vh = new ArrayList<>();
        vehiclesOnFerry = vh;
    }

    @Override
    public int countPassengers() {

        return passengers.size();
    }

    @Override
    public int countVehicleSpace() {
        double space = (double)spaceTakenOnFerry/5;
        return (int) Math.ceil(space);
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
                spaceTakenOnFerry += spaceTaken(v);
                moneyEarned += getMoney(v);
                for (int i = 0; i < v.getPassengers().size(); i++) {
                    passengers.add(v.getPassengers().get(i));
                }

            } else
                System.out.println("There is no space for this " + v.getVehicleType());
        else
            System.out.println("You cant embark the same " + v.getVehicleType());
    }

    @Override
    public void embark(Passenger p) {
        if (hasRoomFor(p)) {
            passengers.add(p);
            moneyEarned += MONEY_PASSENGER_WALKING_ON;
        } else
            System.out.println("There is no room for this passenger");
    }

    @Override
    public void disembark() {
        passengers.clear();
        vehiclesOnFerry.clear();
        spaceTakenOnFerry = 0;
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return (spaceTakenOnFerry + spaceTaken(v)) < MAX_SPACE && (passengers.size() + v.getPassengers().size()) < MAX_PASSENGERS;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return (passengers.size() < MAX_PASSENGERS);

    }

    private int spaceTaken(Vehicle v) {
        if (v instanceof Bicycle)
            return BICYCLE_SPACE_TAKEN;
        else if (v instanceof Car)
            return CAR_SPACE_TAKEN;
        else if (v instanceof Bus)
            return BUS_SPACE_TAKEN;
        else
            return LORRY_SPACE_TAKEN;
    }

    private int getMoney(Vehicle v) {
        if (v instanceof Bicycle)
            return MONEY_BICYCLE;
        else if (v instanceof Car)
            return MONEY_CAR + (15 * v.getPassengers().size());
        else if (v instanceof Bus)
            return MONEY_BUS + (10 * v.getPassengers().size());
        else
            return MONEY_LORRY + (15 * v.getPassengers().size());
    }
}
