import java.util.Scanner;
public class BonusOfEmployees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter your years of service: ");
        int yearsOfService = scanner.nextInt();
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Your bonus is: " + bonus);
        } else {
            System.out.println("No bonus awarded.");
        }
        scanner.close();
    }
}
