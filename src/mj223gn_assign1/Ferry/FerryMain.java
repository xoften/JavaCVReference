package mj223gn_assign1.Ferry;

import java.util.Iterator;

/**
 * Created by Michaels on 2016-01-22.
 */
public class FerryMain {

    public static void main(String[] args) {

        System.out.println("We Create a ferry called StenaLine");
        Ferry StenaLine = new Ferry("StenaLine");

        //we add 5 passengers
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());
        StenaLine.embark(new Passenger());

        //and some vehicles, int i object is number of passengers.
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
        System.out.println("Here the ferry only have 3 car spaces left so if we try to add this buss or lorry,");
        System.out.println("we get and error that says that there is not space.");

        StenaLine.embark(new Bus(16));
        StenaLine.embark(new Lorry(1));

        System.out.println();
        System.out.println("we check the ferry with the toString method");
        System.out.println(StenaLine.toString());

        System.out.println();
        System.out.println("We then iterate through our vehicles on the ferry");
        Iterator<Vehicle> itr = StenaLine.iterator();
        while (itr.hasNext()) {
            Vehicle next = itr.next();
            System.out.println("" + next.getVehicleType() + " with: " + next.getPassengers().size() + " number of passengers.");
        }

        System.out.println("Then we disembark all vehicles and passengers from the ferry.");
        StenaLine.disembark();

        System.out.println("Check so the ferry is empty");
        System.out.println(StenaLine.toString());

        System.out.println();
        System.out.println("Then we try to add 203 passengers to the ferry, for the last 3 we get an error");
        for (int i = 0; i < 203; i++) {
            StenaLine.embark(new Passenger());
        }
        System.out.println();
        System.out.println(StenaLine.toString());
        System.out.println();
        System.out.println("Then with the ferry full on passengers we try to add a car ");
        System.out.println("but with the passengerlist full we cant add the car even if there is space");
        StenaLine.embark(new Car(3));
    }


}
