import java.util.*;

class Product {
    int price;
    int rating;
    int discount;

    Product(int price, int rating, int discount) {
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
}

public class ECommerceSort {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product(2000, 4, 10));
        list.add(new Product(1000, 5, 30));
        list.add(new Product(3000, 3, 20));

        // Sort by PRICE
        list.sort((a, b) -> a.price - b.price);

        for (Product p : list) {
            System.out.println(p.price);
        }
    }
}
