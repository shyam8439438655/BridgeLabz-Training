class CarRental{
    String  customerName;
    String carModel;
    int rentalDays;

    // parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    //  initialize the rental details and calculate total cost.
    int calculateTotalCost(int costPerDay){
        return rentalDays * costPerDay;
    }
    void displayRentalDetails(int costPerDay){
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost(costPerDay));
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        // Create object using parameterized constructor
        CarRental rental1 = new CarRental("Shyam", "Kia Sonet", 5);
        System.out.println("Car Rental Details:");
        rental1.displayRentalDetails(40);
    }
}
