package Dynamic_Online_Marketplace_System;

// Product.java
public class Product<T extends Category> {
    String productName;
    double price;
    T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public void showDetails() {
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category.getCategoryName());
        System.out.println("----------------------");
    }
}

