import java.util.*;

class Invoice {
    Invoice(String id) {
        System.out.println("Invoice created for " + id);
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("TX1", "TX2", "TX3");

        transactionIds.stream().map(Invoice::new).forEach(i -> { });
    }
}
