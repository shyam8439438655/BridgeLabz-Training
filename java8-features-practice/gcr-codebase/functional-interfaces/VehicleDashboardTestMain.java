interface Vehicle {

    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available");
    }
}

class PetrolCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }

    public void displayBattery() {
        System.out.println("Battery: 75%");
    }
}

public class VehicleDashboardTestMain {
    public static void main(String[] args) {

        Vehicle v1 = new PetrolCar();
        Vehicle v2 = new ElectricCar();

        v1.displaySpeed();
        v1.displayBattery();

        v2.displaySpeed();
        v2.displayBattery();
    }
}
