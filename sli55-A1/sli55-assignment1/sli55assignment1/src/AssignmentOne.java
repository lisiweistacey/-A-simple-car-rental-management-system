import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

public class AssignmentOne {
    public static void main(String[] args) {
//  Part 2 – Using abstract classes and interfaces
        System.out.println("Part 2 – Using abstract classes and interfaces");
        RentCar car1 = new RentCar();
        RentCar car2 = new RentCar("Mulsanne", "Bentley", "EWB", false, "Tim",10);
        SaleCar car3 = new SaleCar("F8Tributo", "Ferrari", "Roadster", true,"Stacey");
        car1.printDetails();
        car2.printDetails();
        car3.printDetails();
        System.out.println("------------------------------");

//  Part 3 – Generic classes
        System.out.println("Part 3 – Generic classes");
        ArrayList<Vehicle> listCar = new ArrayList<>();
        RentCar car4 = new RentCar("Cullinan", "Rolls-Royce", "SUV", true, "Peter",50);
        SaleCar car5 = new SaleCar("gtr35", "Nissan", "racing car", false, "Max");
        listCar.add(car2);
        listCar.add(car3);
        listCar.add(car4);
        listCar.add(car5);
        car2.<RentCar>hireThis("Alice");
        car3.<SaleCar>transferOwnership("Bob");
        System.out.println("------------------------------");

//  Part 4 – Polymorphism
        System.out.println("Part 4 – Polymorphism");
        AssignmentOne.printCars(listCar);
        // There are 3 prerequisites for Java to implement polymorphism: inheritance, override, and upward transformation.
        // The subclasses SaleCar and RentCar of the Vehicle class have each method override for the printDetail method in the parent class vehicle,
        // and the methods of the subclass are called when these methods are called.
        // Assign a reference to the subclass to the parent class object so that the reference can call both the methods of the parent class and the methods of the subclass.
        System.out.println("------------------------------");

//  Part 5 - Generic methods
        System.out.println("Part 5 - Generic methods");
        Collections.sort(listCar);
        printCars(listCar); // Print out the listCar after sorting
        System.out.println("------------------------------");

//  Part 6 - Wildcards
        System.out.println("Part 6 - Wildcards");
        // In the form of < extends Vehicle>, Vehicle is the upper boundary of the generic and can accept data from the Vehicle class and its subclasses, SaleCar and RentCar.
        // ArrayList< extends Vehicle> represents an ArrayList collection that can hold instances of the Vehicle class and its subclasses,
        // and it is safe to read elements from the collection and cast them to Vehicle.
        int listCarSum = getTotalAvailableCars(listCar);
        System.out.println("The total number of available vehicles in listCar is: " + listCarSum);
        ArrayList<RentCar> listCar2 = new ArrayList<>();
        listCar2.add(car4);
        int listCar2Sum = getTotalAvailableCars(listCar2);
        System.out.println("The total number of available vehicles in listCar2 is: " + listCar2Sum);
        System.out.println("------------------------------");

//  Part 7 - Simple lambda expressions
        System.out.println("Part 7 - Simple lambda expressions");
        Predicate<Vehicle> predicate = vehicle -> vehicle.getIsAvailable();
        System.out.println("The available cars in listCar are: ");
        printAvailableCars(listCar, predicate);
        System.out.println("------------------------------");
    }

    public static void printCars(ArrayList<Vehicle> listVehicle){
        for(int a = 0; a < listVehicle.size(); a++){
            listVehicle.get(a).printDetails();
        }
    }

    /**
     * Counts available cars in the ArrayList.
     */
    public static int getTotalAvailableCars(ArrayList<? extends Vehicle> cars){
        Iterator<? extends Vehicle> iterator = cars.iterator();
        int s = 0;
        while (iterator.hasNext()){
            Vehicle nextCar = iterator.next();
            if(nextCar.getIsAvailable()){
                s++;
            }
        }
        return s;
    }

    /**
     * Prints all the car details in the ArrayList
     */
    public static void printAvailableCars(ArrayList<Vehicle> listCars, Predicate<Vehicle> predicate){
        for(Vehicle vehicle : listCars){
            if(predicate.test(vehicle))
                vehicle.printDetails();
        }
    }
}
