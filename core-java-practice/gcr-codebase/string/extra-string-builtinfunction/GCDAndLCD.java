import java.util.Scanner;
public class GCDAndLCD {
    // Function to take input from user
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        return new int[]{num1, num2};
    }

    // Function to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Main method
    public static void main(String[] args) {
        int[] numbers = takeInput();
        int num1 = numbers[0];
        int num2 = numbers[1];

        int gcdResult = gcd(num1, num2);
        int lcmResult = lcm(num1, num2);

        // Display results
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcdResult);
        System.out.println("The LCM of " + num1 + " and " + num2 + " is: " + lcmResult);
    }
}