package mj223gn_assign1.Ferry;

import java.util.Iterator;

/**
 * Created by Michael on 2016-01-20.
 */
public interface FerryInterface {

    int countPassengers();
    int countVehicleSpace();
    int countMoney();
    Iterator<Vehicle> iterator();
    void embark(Vehicle v);
    void embark(Passenger p);
    void disembark();

    boolean hasSpaceFor(Vehicle v);
    boolean hasRoomFor(Passenger p);
    String toString();

}
