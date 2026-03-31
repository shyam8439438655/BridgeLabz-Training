// Interface for Discount
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // sensitive detail encapsulated
    private String customerName;

    public FoodItem(String itemName, double price, int quantity, String customerName) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.customerName = customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // encapsulated sensitive info
    protected String getCustomerName() {
        return customerName;
    }

    // abstract method
    public abstract double calculateTotalPrice();

    // concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName +
                           ", Price: " + price +
                           ", Quantity: " + quantity +
                           ", Total Price: " + calculateTotalPrice());
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity, String customerName) {
        super(itemName, price, quantity, customerName);
    }

    @Override
    public double calculateTotalPrice() {
        // Veg items: price * quantity
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        // 10% discount for veg items
        return calculateTotalPrice() * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity, String customerName) {
        super(itemName, price, quantity, customerName);
    }

    @Override
    public double calculateTotalPrice() {
        // Non-veg items: price * quantity + 50 extra charge
        return (getPrice() * getQuantity()) + 50;
    }

    @Override
    public double applyDiscount() {
        // 5% discount for non-veg items
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem f1 = new VegItem("Paneer Butter Masala", 250, 2, "Shyam");
        FoodItem f2 = new NonVegItem("Chicken Biryani", 300, 3, "Ravi");

        FoodItem[] order = {f1, f2};

        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
                System.out.println("Discount Amount: " + d.applyDiscount());
                System.out.println("Final Price after Discount: " + (item.calculateTotalPrice() - d.applyDiscount()));
            }
            System.out.println("-------------------------");
        }
    }
}