import java.util.Scanner;

public class ReplaceWord {

    // Method to replace a word in a sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";

        // Split sentence into words
        String[] words = sentence.split(" ");

        // Loop through each word
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result = result + newWord + " ";
            } else {
                result = result + words[i] + " ";
            }
        }

        return result.trim(); // remove extra space at the end
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Input word to replace
        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();

        // Input new word
        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();

        // Call method
        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        // Output result
        System.out.println("Modified Sentence: " + modifiedSentence);

        sc.close();
    }
}