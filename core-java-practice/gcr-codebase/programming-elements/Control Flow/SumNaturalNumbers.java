// Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 
// Hint => 
// Take the user input number and check whether it's a Natural number
// If it's a natural number Compute using formulae as well as compute using while loop
// Compare the two results and print the result

import java.util.Scanner;
public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a natural number.");
            scanner.close();
            return;
        }
        int sumFormula = n * (n + 1) / 2;
        int sumLoop = 0;
        int i = 1;
        while (i <= n) {
            sumLoop += i;
            i++;
        }
        System.out.println("Sum using formula: " + sumFormula);
        System.out.println("Sum using loop: " + sumLoop);
        if (sumFormula == sumLoop) {
            System.out.println("Both computations are correct.");
        } else {
            System.out.println("There is an error in the computations.");
        }
        scanner.close();
    }
}
    
