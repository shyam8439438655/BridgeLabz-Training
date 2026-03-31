import java.util.Scanner;

public class ToggleCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = "";

        // Loop through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // If uppercase, convert to lowercase
            if (Character.isUpperCase(ch)) {
                result = result + Character.toLowerCase(ch);
            }
            // If lowercase, convert to uppercase
            else if (Character.isLowerCase(ch)) {
                result = result + Character.toUpperCase(ch);
            }
            // If not a letter, keep as it is
            else {
                result = result + ch;
            }
        }

        // Output result
        System.out.println("Toggled String: " + result);

        sc.close();
    }
}