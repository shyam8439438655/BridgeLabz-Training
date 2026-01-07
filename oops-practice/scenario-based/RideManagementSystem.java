import java.util.ArrayList;
import java.util.Scanner;

class NoDriverAvailableException extends Exception {
    NoDriverAvailableException(String msg) {
        super(msg);
    }
}

interface FareCalculator {
    double getFare(double km);
}

class NormalFare implements FareCalculator {
    public double getFare(double km) {
        return km * 10;
    }
}

class PeakFare implements FareCalculator {
    public double getFare(double km) {
        return km * 15;
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Driver {
    int id;
    String name;
    boolean available = true;

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Ride {
    int userId;
    int driverId;
    double distance;
    double fare;

    Ride(int userId, int driverId, double distance, double fare) {
        this.userId = userId;
        this.driverId = driverId;
        this.distance = distance;
        this.fare = fare;
    }
}

class RideManager {

    ArrayList<Driver> drivers = new ArrayList<>();
    ArrayList<Ride> rides = new ArrayList<>();

    void addDriver(Driver d) {
        drivers.add(d);
    }

    Ride bookRide(User user, double km, FareCalculator fareCalculator)
            throws NoDriverAvailableException {

        Driver selectedDriver = null;

        for (Driver d : drivers) {
            if (d.available) {
                selectedDriver = d;
                d.available = false;
                break;
            }
        }

        if (selectedDriver == null) {
            throw new NoDriverAvailableException("No driver available!");
        }

        double fare = fareCalculator.getFare(km);

        Ride ride = new Ride(user.id, selectedDriver.id, km, fare);
        rides.add(ride);
        return ride;
    }

    void endRide(Ride ride) {
        for (Driver d : drivers) {
            if (d.id == ride.driverId) {
                d.available = true;
            }
        }
        System.out.println("Ride Ended | Fare = ₹" + ride.fare);
    }

    void showRides() {
        for (Ride r : rides) {
            System.out.println(
                "UserID: " + r.userId +
                " DriverID: " + r.driverId +
                " Fare: ₹" + r.fare
            );
        }
    }

    void deleteAllRides() {
        rides.clear();
        System.out.println("All rides deleted");
    }
}

public class RideManagementSystem {
    public static void main(String[] args) throws NoDriverAvailableException {

        Scanner sc = new Scanner(System.in);

        RideManager manager = new RideManager();

        manager.addDriver(new Driver(1, "Amit"));
        manager.addDriver(new Driver(2, "Rahul"));

        System.out.print("Enter User ID: ");
        int uid = sc.nextInt();

        sc.nextLine(); // buffer clear

        System.out.print("Enter User Name: ");
        String uname = sc.nextLine();

        User user = new User(uid, uname);

        System.out.print("Enter Distance (km): ");
        double km = sc.nextDouble();

        System.out.print("Is it Peak Time? (true/false): ");
        boolean isPeakTime = sc.nextBoolean();

        FareCalculator fareCalculator;

        if (isPeakTime) {
            fareCalculator = new PeakFare();
        } else {
            fareCalculator = new NormalFare();
        }

        Ride ride = manager.bookRide(user, km, fareCalculator);

        System.out.println("Ride Booked Successfully");

        manager.endRide(ride);
        manager.showRides();
        manager.deleteAllRides();
        sc.close();
    }
}
