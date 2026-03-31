class PalindromeChecker {
    
    String text;

    // Constructor to initialize text
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if text is palindrome
    boolean isPalindrome() {
        // Convert to lowercase and remove spaces
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();

        // Reverse the string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Compare original cleaned string with reversed
        return cleaned.equals(reversed);
    }

    // Method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}

// Main class
public class Palindrome {
    public static void main(String[] args) {
        // Create PalindromeChecker objects
        PalindromeChecker p1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker p2 = new PalindromeChecker("Hello");

        // Display results
        p1.displayResult();
        p2.displayResult();
    }
}