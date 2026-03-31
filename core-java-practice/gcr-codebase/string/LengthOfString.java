import java.util.Scanner;

public class LengthOfString {

    // Method to calculate string length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // will throw exception when index exceeds
                count++;
            }
        } catch (Exception e) {
            // Exception means we've reached the end of the string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();  // nextLine() allows spaces too

        // Find length using custom method
        int customLength = getLength(input);

        // Show result
        System.out.println("Length of the string : " + customLength);

        sc.close();
    }
}