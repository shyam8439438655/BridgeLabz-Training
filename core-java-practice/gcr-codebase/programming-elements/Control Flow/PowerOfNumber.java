import java.util.Scanner;
public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer as base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter a positive integer as power: ");
        int power = scanner.nextInt();
        if (number < 0 || power < 0) {
            System.out.println("Please enter positive integers only.");
        } else {
            int result = 1;
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }
        scanner.close();
    }
}
