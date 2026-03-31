import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(120.5, 130.2, 125.8);
        prices.forEach(p -> System.out.println("Stock Price: " + p));
    }
}