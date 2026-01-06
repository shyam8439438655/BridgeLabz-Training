// Interface for GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle
abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    // sensitive detail encapsulated
    private String driverLicenseNumber;
    private String currentLocation;

    public Vehicle(int vehicleId, String driverName, double ratePerKm, String driverLicenseNumber, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.driverLicenseNumber = driverLicenseNumber;
        this.currentLocation = currentLocation;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // encapsulated sensitive info
    protected String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    protected String getCurrentLocation() {
        return currentLocation;
    }

    protected void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    // abstract method
    public abstract double calculateFare(double distance);

    // concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId +
                           ", Driver: " + driverName +
                           ", Rate per Km: " + ratePerKm +
                           ", Current Location: " + currentLocation);
    }
}

// Car class
class Car extends Vehicle implements GPS {
    public Car(int vehicleId, String driverName, double ratePerKm, String driverLicenseNumber, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, driverLicenseNumber, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        // Cars: ratePerKm * distance + fixed service charge
        return (getRatePerKm() * distance) + 50;
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Car location updated to: " + newLocation);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    public Bike(int vehicleId, String driverName, double ratePerKm, String driverLicenseNumber, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, driverLicenseNumber, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        // Bikes: cheaper fare, no service charge
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Bike location updated to: " + newLocation);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    public Auto(int vehicleId, String driverName, double ratePerKm, String driverLicenseNumber, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, driverLicenseNumber, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        // Autos: ratePerKm * distance with 10% discount
        return (getRatePerKm() * distance) * 0.90;
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Auto location updated to: " + newLocation);
    }
}

// Main class
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle v1 = new Car(101, "Shyam", 15, "DL-CAR-001", "Mathura");
        Vehicle v2 = new Bike(102, "Ravi", 8, "DL-BIKE-002", "Agra");
        Vehicle v3 = new Auto(103, "Amit", 10, "DL-AUTO-003", "Delhi");

        Vehicle[] rides = {v1, v2, v3};

        double distance = 12.5; // km

        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
            if (v instanceof GPS) {
                GPS gps = (GPS) v;
                System.out.println("Current Location: " + gps.getCurrentLocation());
                gps.updateLocation("Noida");
            }
            System.out.println("-------------------------");
        }
    }
}