import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();

        System.out.println(
            "The addition, subtraction, multiplication, and division value of 2 numbers "
            + n1 + " and " + n2 + " is "
            + (n1 + n2) + ", " + (n1 - n2) + ", " + (n1 * n2) + ", and " + (n1 / n2)
        );
        scanner.close();
    }
}
