package Dynamic_Online_Marketplace_System;

// Catalog.java
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    // Mixed categories allowed (type safe with wildcard)
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void showAllProducts() {
        for (Product<? extends Category> p : products) {
            p.showDetails();
        }
    }
}

