import java.util.Scanner;
public class SmallestAndLargest {
    // Method to find smallest and largest
    public static void findSmallestAndLargest(int num1, int num2, int num3) {
        int smallest = num1;
        int largest = num1;

        // Finding smallest
        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }

        // Finding largest
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }

        // Output
        System.out.println("Smallest number is: " + smallest);
        System.out.println("Largest number is: " + largest);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        // Calling the method
        findSmallestAndLargest(num1, num2, num3);
        scanner.close();
    }
}