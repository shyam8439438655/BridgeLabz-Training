import java.util.Scanner;

public class BasicCalsi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user inputs
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();

        // Perform operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;
        // Output results
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + addition + ", " + subtraction + ", " + multiplication + ", and " + division); 
        sc.close();
    }
}
