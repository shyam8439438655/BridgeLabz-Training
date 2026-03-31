interface  FareCalculator{
    double calculateFare(double distance);
}

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

class User {
    String name;
    User(String name){
        this.name = name;
    }
}

class Driver {
    String driverName;
    boolean available;
    Driver(String driverName){
        this.driverName = driverName;
        this.available = true;
    } 
}

class Ride {
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(User user, Driver driver, double distance, FareCalculator calculator){
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = calculator.calculateFare(distance);
    }

    void displayInfo(){
        System.out.println("User: " + user.name);
        System.out.println("Driver: " + driver.driverName);
        System.out.println("Distance: " + distance);
        System.out.println("Fare: " + fare);
        System.out.println("______________");
    }
}

public class CabBookingSystem {

    static Driver assignDriver(Driver[] drivers) throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.available) {
                d.available = false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No driver available");
    }

    // main method 
    public static void main(String[] args) throws NoDriverAvailableException {

        User user1 = new User("Shyam");

        Driver[] drivers = {
            new Driver("Rahul"),
            new Driver("Amit")
        };

        FareCalculator fareCalculator = new NormalFare(); // Polymorphism

        Driver driver = assignDriver(drivers);

        Ride ride = new Ride(user1, driver, 5, fareCalculator);

        ride.displayInfo();
    }
}