import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String customer;
    private double total;

    public Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }

    public String getCustomer() { return customer; }
    public double getTotal() { return total; }
}

public class OrderRevenueSummingDouble {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Amit", 1200.50),
                new Order("Neha",  500.00),
                new Order("Amit",  300.00),
                new Order("Neha",  700.25),
                new Order("Ravi",  150.00)
        );

        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(Order::getTotal)   
                ));

        System.out.println(revenueByCustomer);
    }
}
