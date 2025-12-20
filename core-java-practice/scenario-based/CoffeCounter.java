import java.util.Scanner;
public class CoffeCounter {
        public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {   // Continue for next customer

            System.out.print("Enter coffee type (espresso / latte / cappuccino) or 'exit' to stop: ");
            String coffee = scanner.next().toLowerCase();

            // break when user types exit
            if (coffee.equals("exit")) {
                System.out.println("Billing stopped. Thank you!");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            double price = 0;

            // Ask for coffee type using SWITCH
            switch (coffee) {
                case "espresso":
                    price = 120;
                    break;

                case "latte":
                    price = 150;
                    break;

                case "cappuccino":
                    price = 180;
                    break;

                default:
                    System.out.println("Invalid coffee type! Try again.\n");
                    continue;  // goes back to while loop
            }
            double total = price * quantity; //  Calculate total bill
            double gst = total * 0.18; //  Add GST (using arithmetic operator)
            double finalAmount = total + gst; //  Add GST (using arithmetic operator)

            System.out.println("Total Bill (with GST) = " + finalAmount);
            System.out.println("----------------------------------");
        }

        scanner.close();
    }
}