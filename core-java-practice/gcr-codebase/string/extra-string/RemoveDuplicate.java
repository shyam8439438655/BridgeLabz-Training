import java.util.Scanner;

public class RemoveDuplicate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = "";

        // Loop through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // If character not already in result, add it
            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }
        }

        // Output result
        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}