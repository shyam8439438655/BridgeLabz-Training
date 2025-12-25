import java.util.Scanner;

public class RemoveSpecificChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Input character to remove
        System.out.print("Enter the character to remove: ");
        char removeChar = sc.next().charAt(0);

        String result = "";

        // Loop through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Add only if not equal to removeChar
            if (ch != removeChar) {
                result = result + ch;
            }
        }

        // Output result
        System.out.println("Modified String: " + result);

        sc.close();
    }
}