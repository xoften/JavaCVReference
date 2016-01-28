package mj223gn_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michael on 2016-01-20.
 */
public class Ferry implements FerryInterface {

    private String ferryName;
    //money earned buy the ferry.
    private int moneyEarned;
    //how much space is taken on the ferry
    private int spaceTakenOnFerry;
    //max passengers and space on ferry
    private final int MAX_PASSENGERS = 200;
    private final int MAX_SPACE = 200;
    //the ferry prices for passengers and all vehicle
    private final int MONEY_PASSENGER_WALKING_ON = 20;
    private final int MONEY_LORRY = 300;
    private final int MONEY_BUS = 200;
    private final int MONEY_CAR = 100;
    private final int MONEY_BICYCLE = 40;
    //how much space each vehicle takes on the ferry
    private final int BICYCLE_SPACE_TAKEN = 1;
    private final int CAR_SPACE_TAKEN = 5;
    private final int BUS_SPACE_TAKEN = 20;
    private final int LORRY_SPACE_TAKEN = 40;
    private ArrayList<Passenger> passengers;
    private ArrayList<Vehicle> vehiclesOnFerry;

    /**
     * Constructor for a ferry
     * @param name the ferry's name.
     */
    public Ferry(String name) {
        ferryName = name;

        spaceTakenOnFerry = 0;

        passengers = new ArrayList<>();

        vehiclesOnFerry = new ArrayList<>();

    }

    /**
     * Method to check how many passenger the ferry has on board
     * @return number of passengers on board
     */
    @Override
    public int countPassengers() {

        return passengers.size();
    }

    /**
     * Method to take out used space on the ferry.
     * this returns the value in cars, 40 is max.
     * @return space taken on the ferry.
     */
    @Override
    public int countVehicleSpace() {
        double space = (double) spaceTakenOnFerry / 5;
        //we round up, cause bicycle take 0.2, so 1-5 bicycle takes 1 car space.
        //when we add the 6'th they take 2 car spaces.
        return (int) Math.ceil(space);
    }

    /**
     * Method to return money earned by the ferry.
     * @return money earned
     */
    @Override
    public int countMoney() {
        return moneyEarned;
    }

    /**
     * Iterator to go through the vehicles on the ferry
     * @return iterator for vehicles
     */
    @Override
    public Iterator<Vehicle> iterator() {
        return new VehicleIterator(vehiclesOnFerry);
    }

    /**
     * Method to embark a vehicle on to the ferry.
     * @param v vehicle to embark
     */
    @Override
    public void embark(Vehicle v) {
        //check so the vehicle isn't already on the ferry
        if (!vehiclesOnFerry.contains(v))
            //check so the ferry has space for this vehicle
            if (this.hasSpaceFor(v)) {
                //add the vehicle to the ferry's list.
                vehiclesOnFerry.add(v);
                spaceTakenOnFerry += spaceTaken(v);
                moneyEarned += getMoney(v);
                //for every passenger on the vehicle add them to the ferry's passenger list
                for (int i = 0; i < v.getPassengers().size(); i++) {
                    passengers.add(v.getPassengers().get(i));
                }

            } else
                System.out.println("There is no space for this " + v.getVehicleType());
        else
            System.out.println("You cant embark the same " + v.getVehicleType());
    }

    /**
     * Method to embark a passenger that walks on to the ferry.
     * @param p passenger to add to the ferry
     */
    @Override
    public void embark(Passenger p) {
        if (hasRoomFor(p)) {
            passengers.add(p);
            moneyEarned += MONEY_PASSENGER_WALKING_ON;
        } else
            System.out.println("There is no room for this passenger");
    }

    /**
     * Method to disembark all vehicles and passengers
     */
    @Override
    public void disembark() {
        passengers.clear();
        vehiclesOnFerry.clear();
        spaceTakenOnFerry = 0;
    }

    /**
     * Method to check if the ferry has room for a vehicle.
     * we check so there is space for the vehicle and the passengers. so if
     * one of them is full we cant add the vehicle.
     *
     * @param v the vehicle we want to embark
     * @return true if there is space, false if there is no space for this vehicle
     */
    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return (spaceTakenOnFerry + spaceTaken(v)) < MAX_SPACE && (passengers.size() + v.getPassengers().size()) < MAX_PASSENGERS;
    }

    /**
     * Method to check if there is room for a passenger on the ferry
     * @param p passenger we want to add
     * @return true if there is space, false if not.
     */
    @Override
    public boolean hasRoomFor(Passenger p) {
        return (passengers.size() < MAX_PASSENGERS);

    }

    /**
     * To string method to write out a ferry.
     * @return ferry in string
     */
    @Override
    public String toString(){
        String ferry = ferryName + " has ";
        String passengers = countPassengers() + " passengers and ";
        String vehicles = vehiclesOnFerry.size() + " number of vehicles on board " +countVehicleSpace() +"/40 space taken, ";
        String money = ferryName + " has also " + countMoney() + " money earned";
        return ferry + passengers + vehicles + money;
    }

    /**
     * Help method to get space taken for each vehicle
     * @param v vehicle we want to check
     * @return how much space that vehicle takes on the ferry
     */
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

    /**
     * Help method to check how much a vehicle shall pay to embark on the ferry
     * @param v vehicle we want to embark
     * @return how much money that vehicle shall pay the ferry
     */
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
