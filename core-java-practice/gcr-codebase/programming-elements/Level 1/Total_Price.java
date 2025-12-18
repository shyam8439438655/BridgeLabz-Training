import java.util.Scanner;
public class Total_Price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take user input
        double unitPrice = sc.nextDouble();
        int quantity = sc.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        // Output
        System.out.println("The total purchase price is INR " + totalPrice +
                           " if the quantity " + quantity +
                           " and unit price is INR " + unitPrice);
        sc.close();
    }
}
