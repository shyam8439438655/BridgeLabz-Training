import java.util.Scanner;

public class MaximumOfThree {

    // Function to take input from user
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];  // array to store 3 numbers

        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();

        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();

        return numbers;
    }

    // Function to calculate maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        int max = a;  // assume first number is max

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    // Main method
    public static void main(String[] args) {
        // Step 1: Take input
        int[] nums = takeInput();

        // Step 2: Find maximum
        int max = findMaximum(nums[0], nums[1], nums[2]);

        // Step 3: Display result
        System.out.println("The maximum number is: " + max);
    }
}