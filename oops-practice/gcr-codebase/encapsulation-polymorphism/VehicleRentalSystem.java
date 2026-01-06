interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // sensitive detail encapsulated
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // encapsulated sensitive info
    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    // abstract method
    public abstract double calculateRentalCost(int days);

    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber +
                           ", Type: " + type +
                           ", Rental Rate: " + rentalRate +
                           ", Rental Cost for " + days + " days: " + calculateRentalCost(days));
    }
}

// Car class
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Cars: rentalRate * days
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // Insurance: 10% of rental cost
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + getInsurancePolicyNumber() + ", Rate: 10% of rental rate";
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Bikes: rentalRate * days with 5% discount
        return (getRentalRate() * days) * 0.95;
    }

    @Override
    public double calculateInsurance() {
        // Insurance: 5% of rental cost
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + getInsurancePolicyNumber() + ", Rate: 5% of rental rate";
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        // Trucks: rentalRate * days + fixed surcharge
        return (getRentalRate() * days) + 500;
    }

    @Override
    public double calculateInsurance() {
        // Insurance: 15% of rental cost
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + getInsurancePolicyNumber() + ", Rate: 15% of rental rate";
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car("CAR101", 2000, "CAR-INS-001");
        Vehicle v2 = new Bike("BIKE202", 500, "BIKE-INS-002");
        Vehicle v3 = new Truck("TRUCK303", 5000, "TRUCK-INS-003");

        Vehicle[] vehicles = {v1, v2, v3};

        int days = 5;

        for (Vehicle v : vehicles) {
            v.displayDetails(days);
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost: " + ins.calculateInsurance());
            }
            System.out.println("-------------------------");
        }
    }
}