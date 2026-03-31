class Vehicle {
    String ownerName;
    String vehicletype;

    static int registrationFee = 1200;

    // parameterized constructor
    Vehicle(String ownerName, String vehicletype) {
        this.ownerName = ownerName;
        this.vehicletype = vehicletype;
    }
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicletype);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    static void displayRegistrationFee() {
        System.out.println("Standard Registration Fee: $" + registrationFee);
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        // Create vehicle objects
        Vehicle vehicle1 = new Vehicle("Prince", "Car");
        Vehicle vehicle2 = new Vehicle("Shyam", "Super Bike ");

        // Display vehicle details
        System.out.println("Vehicle 1 Details:");
        vehicle1.displayVehicleDetails();
        System.out.println(); // Just for better readability

        System.out.println("Vehicle 2 Details:");
        vehicle2.displayVehicleDetails();
        System.out.println(); // Just for better readability

        // Display standard registration fee
        Vehicle.displayRegistrationFee();
    }
}
