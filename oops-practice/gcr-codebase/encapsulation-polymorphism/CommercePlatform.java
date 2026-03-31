interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

 abstract class Product{
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId , String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    } 

    public int getProductId(){
        return productId;
    }

    public int setProductId(int productId){
        this.productId = productId;
        return productId;
    }

    public String getName(){
        return name;
    }

    public String setName(String name){
        this.name = name;
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int setPrice(int price){
        this.price = price;
        return price;
    }

    // abstract method
    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId +
                           ", Name: " + name +
                           ", Price: " + price +
                           ", Discounted Price: " + (price - calculateDiscount()));
    }
 }
// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    
    public double calculateDiscount() {
        // 10% discount for electronics
        return getPrice() * 0.10;
    }

    
    public double calculateTax() {
        // 18% GST for electronics
        return (getPrice() - calculateDiscount()) * 0.18;
    }

    
    public String getTaxDetails() {
        return "Electronics tax rate: 18% GST";
    }
}

// Clothing class

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 20% discount for clothing
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        // 5% GST for clothing
        return (getPrice() - calculateDiscount()) * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing tax rate: 5% GST";
    }
}

//
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 5% discount for groceries
        return getPrice() * 0.05;
    }
}

   public class CommercePlatform {
      public static void main(String[] args) {
         Product p1 = new Electronics(201, "Laptop", 60000);
         Product p2 = new Clothing(202, "T-Shirt", 1000);
         Product p3 = new Groceries(203, "Rice Bag", 2000);

         Product[] products = {p1, p2, p3};

         for (Product p : products) {
             p.displayDetails();
             if (p instanceof Taxable) {
                 Taxable t = (Taxable) p;
                 System.out.println(t.getTaxDetails());
                 System.out.println("Tax Amount: " + t.calculateTax());
             }
              System.out.println("-------------------------");

      }
   }

}


