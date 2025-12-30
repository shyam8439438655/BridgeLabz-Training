import java.util.Scanner;

public class SimpleCharFrequency {

    // Method to find frequency using nested loops
    public static void findFrequency(String str) {
        char[] chars = str.toCharArray();   // convert string to char array

        System.out.println("\nCharacter Frequencies:");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') continue; // skip already counted

            int count = 1; // start frequency

            // inner loop to check duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                    chars[j] = '0'; // mark duplicate
                }
            }

            System.out.println(chars[i] + " -> " + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // call method
        findFrequency(input);

        sc.close();
    }
}