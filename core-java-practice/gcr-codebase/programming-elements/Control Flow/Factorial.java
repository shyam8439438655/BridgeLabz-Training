// Write a Program to find the factorial of an integer entered by the user.
// Hint => 
// For example, the factorial of 4 is 1 * 2 * 3 * 4 which is 24.
// Take an integer input from the user and assign it to the variable. Check the user has entered a positive integer.
// Using a while loop, compute the factorial.
// Print the factorial at the end.

import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int factorial = 1;
            int temp = number;
            while (temp > 1) {
                factorial *= temp;
                temp--;
            }
            System.out.println("Factorial of " + number + " is: " + factorial);
            scanner.close();
        }
    }
}
