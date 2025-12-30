import java.util.Scanner;
public class PosOrNegaAndEvenOrOdd {
    // Method to check if a number is positive or negative
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    // Method to check if a number is even or odd
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    // Method to compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Taking user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        // Checking each number for positive/negative and even/odd
        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.print(number + " is Positive and ");
                if (isEven(number)) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println(number + " is Negative");
            }
        }
        // Comparing the first and last elements of the array
        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparisonResult == 1) {
            System.out.println("The first number " + numbers[0] + " is greater than the last number " + numbers[numbers.length - 1]);
        } else if (comparisonResult == -1) {
            System.out.println("The first number " + numbers[0] + " is less than the last number " + numbers[numbers.length - 1]);
        } else {
            System.out.println("The first number " + numbers[0] + " is equal to the last number " + numbers[numbers.length - 1]);
        }
        scanner.close();
    }
}