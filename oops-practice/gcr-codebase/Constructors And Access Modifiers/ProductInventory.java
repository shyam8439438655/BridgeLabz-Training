class Product {
    String productName;
    double price;
    static int totalProducts = 0; // class variable to keep track of total products

    // parameterized constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment total products whenever a new product is created
    }

    // instance method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // class method to display total products
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}
public class ProductInventory {
    public static void main(String[] args) {
        // Create product objects
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.49);
        
        // Display product details
        System.out.println("Product 1 Details:");
        product1.displayProductDetails();
        System.out.println(); // Just for better readability
        
        System.out.println("Product 2 Details:");
        product2.displayProductDetails();
        System.out.println(); // Just for better readability
        
        // Display total products
        Product.displayTotalProducts();
    }
} 