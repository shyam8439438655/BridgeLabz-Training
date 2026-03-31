class Product {
    static double discount = 10.0; // shared discount
    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    //  Static method to update discount
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    // Display details only if object is Product
    void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price after Discount: $" + discountedPrice);
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product.updateDiscount(10.0);
        Product p1 = new Product("P001", "Laptop", 1200.0, 5);
        Product p2 = new Product("P002", "Smartphone", 800.0, 10);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}