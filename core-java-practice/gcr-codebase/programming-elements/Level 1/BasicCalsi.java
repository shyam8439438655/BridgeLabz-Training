import java.util.Scanner;

public class BasicCalsi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user inputs
        double number1 = scanner.nextDouble();
        double number2 = scanner.nextDouble();

        // Perform operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;
        // Output results
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + division); 
        scanner.close();
    }
}
