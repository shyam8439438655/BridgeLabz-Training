import java.util.Scanner;

public class Handshake{

    // Method to calculate maximum handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;   // Combination formula
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Calling the method
        int handshakes = calculateHandshakes(numberOfStudents);

        // Display the result
        System.out.println("Maximum number of possible handshakes = " + handshakes);
        input.close();
    }
}
