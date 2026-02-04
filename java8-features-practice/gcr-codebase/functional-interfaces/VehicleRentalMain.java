// Interface
interface VehicleRental {
    void rent();
    void returnVehicle();
}

// Car
class Car implements VehicleRental {
    public void rent() {
        System.out.println("Car rented");
    }
    public void returnVehicle() {
        System.out.println("Car returned");
    }
}

// Bike
class Bike implements VehicleRental {
    public void rent() {
        System.out.println("Bike rented");
    }
    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}

// Bus
class Bus implements VehicleRental {
    public void rent() {
        System.out.println("Bus rented");
    }
    public void returnVehicle() {
        System.out.println("Bus returned");
    }
}

// Main
public class VehicleRentalMain {
    public static void main(String[] args) {
        VehicleRental v1 = new Car();
        VehicleRental v2 = new Bike();
        VehicleRental v3 = new Bus();

        v1.rent(); v1.returnVehicle();
        v2.rent(); v2.returnVehicle();
        v3.rent(); v3.returnVehicle();
    }
}
