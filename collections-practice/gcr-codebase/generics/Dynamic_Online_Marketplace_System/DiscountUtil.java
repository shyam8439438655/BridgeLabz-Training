package Dynamic_Online_Marketplace_System;

// DiscountUtil.java
public class DiscountUtil {

    // Generic Method with bounded type parameter
    public static <T extends Product<? extends Category>> void applyDiscount(T product, double percentage) {
        double discountAmount = (product.price * percentage) / 100;
        product.price = product.price - discountAmount;
    }
}

