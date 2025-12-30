class CartItem {
   
    String itemName;
    double price;
    int quantity;

    // Constructor to initialize item details
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items to the cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items from the cart
    void removeItem(int qty) {
        if (quantity >= qty) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove " + qty + " items. Only " + quantity + " available.");
        }
    }

    // Method to calculate total cost
    double calculateTotalCost() {
        return price * quantity;
    }

    // Method to display item details
    void displayDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

// Main class
public class ShoppingCart {
    public static void main(String[] args) {
        // Create a CartItem object
        CartItem item1 = new CartItem("Laptop", 999.99, 1);

        // Display initial details
        item1.displayDetails();

        // Add items
        item1.addItem(2);

        // Remove items
        item1.removeItem(1);

        // Display total cost
        System.out.println("Total cost: $" + item1.calculateTotalCost());
    }
}