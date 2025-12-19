import java.util.Scanner;
public class StudFee9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        System.out.print("Enter the original fee: ");// original fee
        double fee = scanner.nextDouble();              
        double discountPercent = scanner.nextDouble();  // discount percentage

        // Calculate discount
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;

        // Output
        System.out.println("The discount amount is INR " + discount +" and final discounted fee is INR " + finalFee);
        scanner.close(); // Close the scanner
    }
}
