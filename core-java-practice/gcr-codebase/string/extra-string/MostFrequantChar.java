import java.util.Scanner;

public class MostFrequantChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int[] freq = new int[256]; // frequency array for all characters (ASCII)

        // Count frequency of each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch]++;
        }

        // Find most frequent character
        char mostFreqChar = input.charAt(0);
        int maxCount = freq[mostFreqChar];

        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                mostFreqChar = ch;
            }
        }

        // Output result
        System.out.println("Most Frequent Character: '" + mostFreqChar + "'");

        sc.close();
    }
}