import java.util.Scanner;
public class SumUntillNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double num;
        System.out.print("Enter a number (negative to stop): ");
        num = scanner.nextDouble();
        while (num >= 0) {
            total += num;
            System.out.print("Enter another number (negative to stop): ");
            num = scanner.nextDouble();
        }
        System.out.println("Total sum = " + total);
        scanner.close();
    }   
}
