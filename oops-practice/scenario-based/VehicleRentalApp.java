import java.util.ArrayList;
import java.util.Scanner;

//  INTERFACE 
interface IRentable {
    double calculateRent(int days);
}

//  CUSTOMER 
class Customer {
    private int customerId;
    private String name;

    Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    void displayCustomer() {
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + name);
    }
}

//  VEHICLE
class Vehicle {
    protected int vehicleId;      // protected field
    protected String brand;        // protected field
    protected double pricePerDay;  // protected field
    protected Customer customer;

    Vehicle(int vehicleId, String brand, double pricePerDay, Customer customer) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.customer = customer;
    }

    void displayInfo() {
        System.out.println("Vehicle ID    : " + vehicleId);
        System.out.println("Brand         : " + brand);
        System.out.println("Price/Day     : ₹" + pricePerDay);
        customer.displayCustomer();
    }
}

// BIKE
class Bike extends Vehicle implements IRentable {

    Bike(int id, String brand, double price, Customer customer) {
        super(id, brand, price, customer);
    }

    public double calculateRent(int days) {
        return days * pricePerDay;
    }

    void displayInfo(int days) {
        super.displayInfo();
        System.out.println("Vehicle Type  : Bike");
        System.out.println("Total Rent   : ₹" + calculateRent(days));
    }
}

//  CAR 
class Car extends Vehicle implements IRentable {

    Car(int id, String brand, double price, Customer customer) {
        super(id, brand, price, customer);
    }

    public double calculateRent(int days) {
        return days * pricePerDay + 500; // extra charge
    }

    void displayInfo(int days) {
        super.displayInfo();
        System.out.println("Vehicle Type  : Car");
        System.out.println("Total Rent   : ₹" + calculateRent(days));
    }
}

// TRUCK 
class Truck extends Vehicle implements IRentable {

    Truck(int id, String brand, double price, Customer customer) {
        super(id, brand, price, customer);
    }

    public double calculateRent(int days) {
        return days * pricePerDay + 1000; // extra charge
    }

    void displayInfo(int days) {
        super.displayInfo();
        System.out.println("Vehicle Type  : Truck");
        System.out.println("Total Rent   : ₹" + calculateRent(days));
    }
}

//  MAIN CLASS
public class VehicleRentalApp {

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("1. Add Vehicle on Rent");
            System.out.println("2. View All Rentals");
            System.out.println("3. Delete Rental");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addVehicle();
            } 
            else if (choice == 2) {
                viewVehicles();
            } 
            else if (choice == 3) {
                deleteVehicle();
            } 
            else if (choice == 4) {
                System.out.println("Application Closed.");
            } 
            else {
                System.out.println("Invalid Choice!");
            }
        }
    }

    // ADD 
    static void addVehicle() {

        System.out.print("Vehicle ID: ");
        int vid = sc.nextInt();
        sc.nextLine();

        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Price per Day: ");
        double price = sc.nextDouble();
        sc.nextLine();

        // Customer
        System.out.print("Customer ID: ");
        int cid = sc.nextInt();
        sc.nextLine();

        System.out.print("Customer Name: ");
        String cname = sc.nextLine();

        Customer customer = new Customer(cid, cname);

        System.out.print("1.Bike  2.Car  3.Truck : ");
        int type = sc.nextInt();

        if (type == 1) {
            vehicles.add(new Bike(vid, brand, price, customer));
        } 
        else if (type == 2) {
            vehicles.add(new Car(vid, brand, price, customer));
        } 
        else {
            vehicles.add(new Truck(vid, brand, price, customer));
        }

        System.out.println("Vehicle Rented Successfully!");
    }

    //  VIEW
    static void viewVehicles() {

        if (vehicles.size() == 0) {
            System.out.println("No Rentals Found!");
            return;
        }

        System.out.print("Enter Rental Days: ");
        int days = sc.nextInt();

        for (Vehicle v : vehicles) {
            System.out.println("-------------------------");

            if (v instanceof Bike) {
                ((Bike) v).displayInfo(days);
            } 
            else if (v instanceof Car) {
                ((Car) v).displayInfo(days);
            } 
            else if (v instanceof Truck) {
                ((Truck) v).displayInfo(days);
            }
        }
    }

    //  DELETE 
    static void deleteVehicle() {

        System.out.print("Enter Vehicle ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).vehicleId == id) {
                vehicles.remove(i);
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Rental Deleted Successfully!");
        else
            System.out.println("Vehicle Not Found!");
    }
}
