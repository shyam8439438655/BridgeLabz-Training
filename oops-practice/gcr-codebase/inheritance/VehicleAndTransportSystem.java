class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle{
    int seatCapacity;
    Truck(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Motorcycle extends Vehicle{
    int seatCapacity;
    Motorcycle(int maxSpeed, String fuelType , int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

        @Override
        void displayInfo() {
            super.displayInfo();
            System.out.println("Seat Capacity" + seatCapacity);
        }
}

public class VehicleAndTransportSystem{
    public static void main(String[] args) {  
    Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", 15);
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }

}