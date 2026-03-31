import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Starting balance
        double balance = 0;
        System.out.print("Enter initial balance for Metro Smart Card: ₹");
        balance = sc.nextDouble();

        System.out.println("Welcome to Delhi Metro 🚇");
        System.out.println("Your starting balance: ₹" + balance + "\n");

        while (true) {

            // Stop if balance is over
            if (balance <= 0) {
                System.out.println("Your card balance is Zero. Please recharge!");
                break;
            }

            System.out.print("Enter distance (km) OR -1 to exit: ");
            int distance = sc.nextInt();

            // Quit condition
            if (distance == -1) {
                System.out.println("Thank you for using Metro!");
                break;
            }

            // Using ternary operator for fare
            // (Just an example: distance <= 5 → ₹10, else → ₹20)
            double fare = (distance <= 5) ? 10 : 20;

            System.out.println("Fare for this trip: ₹" + fare);

            // Deduct fare
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted. Remaining balance: ₹" + balance + "\n");
            } else {
                System.out.println("Not enough balance to travel!");
                break;
            }

        }

        sc.close();
    }
}
