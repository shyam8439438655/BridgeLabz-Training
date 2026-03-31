import java.util.Scanner;
public class NumberIsPositiveOrNagative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        // Taking user input for 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        // Checking each number for positive, negative, or zero
        for (int number : numbers) {
            if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println(number + " is a positive even number.");
                } else {
                    System.out.println(number + " is a positive odd number.");
                }
            } else if (number < 0) {
                System.out.println(number + " is a negative number.");
            } else {
                System.out.println("The number is zero.");
            }
        }
        // Comparing the first and last elements of the array
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("The first and last numbers are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("The first number is greater than the last number.");
        } else {
            System.out.println("The first number is less than the last number.");
        }
        scanner.close();
    }
}
