package mj223gn_assign1.Ferry;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-01-22.
 */
public class FerryMain {

    public static void main(String[] args) {

        Ferry Silja = new Ferry();

        for (int i = 0; i < 5; i++)
            Silja.embark(new Bicycle());

        System.out.println(Silja.countVehicleSpace());

        Silja.embark(new Bicycle());

        System.out.println(Silja.countVehicleSpace());

        Ferry StenaLine = new Ferry();

        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());

        StenaLine.embark(new Lorry(1));
        StenaLine.embark(new Lorry(2));
        StenaLine.embark(new Bus(17));
        StenaLine.embark(new Bicycle());
        StenaLine.embark(new Car(3));
        StenaLine.embark(new Bicycle());
        StenaLine.embark(new Car(3));
        StenaLine.embark(new Car(2));
        StenaLine.embark(new Car(1));
        StenaLine.embark(new Bus(20));
        StenaLine.embark(new Lorry(2));
        StenaLine.embark(new Bus(16));
        StenaLine.embark(new Lorry(1));

        System.out.println(StenaLine.countMoney());
        System.out.println(StenaLine.countPassengers());
        System.out.println(StenaLine.countVehicleSpace());

        Iterator<Vehicle> itr = StenaLine.iterator();
        while (itr.hasNext()) {
            Vehicle next = itr.next();
            System.out.println("" + next.getVehicleType() + " with: " + next.getPassengers().size() + " number of passengers.");
        }

        StenaLine.disembark();

        System.out.println(StenaLine.countMoney());
        System.out.println(StenaLine.countPassengers());
        System.out.println(StenaLine.countVehicleSpace());

        for (int i = 0; i < 210; i++) {
            StenaLine.embark(new Passenger());
        }
        System.out.println(StenaLine.countMoney());
        System.out.println(StenaLine.countPassengers());
        System.out.println(StenaLine.countVehicleSpace());

        StenaLine.embark(new Car(3));
    }


}
