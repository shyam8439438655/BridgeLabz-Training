class Item {
    
    String itemCode;
    String itemName;
    double price;

    // Constructor to initialize item details
    Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    void displayDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    // Method to calculate total cost for a given quantity
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

// Main class
public class InventoryTracker {
    public static void main(String[] args) {
        // Create Item objects
        Item item1 = new Item("01AA", "Water bottle", 500.0);
        Item item2 = new Item("01BB", "Rice", 700.0);
        Item item3 = new Item("02AA", "blackboard", 400.0);

        // Display details of items
        item1.displayDetails();
        item2.displayDetails();
        item3.displayDetails();

        // Example: Calculate total cost for quantity
        int qty = 3;
        double total = item1.calculateTotalCost(qty);
        System.out.println("Total cost of " + qty + " " + item1.itemName + "s = " + total);
    }
}