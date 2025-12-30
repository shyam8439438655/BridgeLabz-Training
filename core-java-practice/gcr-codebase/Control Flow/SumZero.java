import java.util.Scanner;
public class SumZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double num;

        System.out.print("Enter a number (0 to stop): ");
        num = scanner.nextDouble();

        while (num != 0) {
            total += num;
            System.out.print("Enter another number (0 to stop): ");
            num = scanner.nextDouble();
        }

        System.out.println("Total sum = " + total);
        scanner.close();
    }
}
