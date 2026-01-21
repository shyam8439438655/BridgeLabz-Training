package Dynamic_Online_Marketplace_System;

// MarketplaceMain.java
public class Marketplace {
    public static void main(String[] args) {

        // Categories
        BookCategory fiction = new BookCategory("Fiction");
        ClothingCategory menWear = new ClothingCategory("Men Wear");
        GadgetCategory mobile = new GadgetCategory("Mobiles");

        // Products
        Product<BookCategory> book1 = new Product<>("Atomic Habits", 450, fiction);
        Product<ClothingCategory> cloth1 = new Product<>("T-Shirt", 799, menWear);
        Product<GadgetCategory> gadget1 = new Product<>("Smartphone", 15000, mobile);

        // Catalog (mixed categories)
        Catalog catalog = new Catalog();
        catalog.addProduct(book1);
        catalog.addProduct(cloth1);
        catalog.addProduct(gadget1);

        System.out.println("Before Discount:");
        catalog.showAllProducts();

        // Apply discount dynamically
        DiscountUtil.applyDiscount(book1, 10);
        DiscountUtil.applyDiscount(cloth1, 20);
        DiscountUtil.applyDiscount(gadget1, 5);

        System.out.println("\nAfter Discount:");
        catalog.showAllProducts();
    }
}

