class MobilePhone {
    
    String brand;
    String model;
    double price;

    // Constructor to initialize mobile phone details
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone details
    void displayDetails() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }
}

// Main class
public class MobileDetails {
    public static void main(String[] args) {
        // Create MobilePhone objects
        MobilePhone phone1 = new MobilePhone("VIVO", "VIVO V29", 15999.0);
        MobilePhone phone2 = new MobilePhone("ONE PLUS", "ONE PLUS nord4", 39999.0);
        MobilePhone phone3 = new MobilePhone("APPLE", "iphone pro16", 79999.0);

        // Display details of each phone
        phone1.displayDetails();
        phone2.displayDetails();
        phone3.displayDetails();
    }
}