import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Think of a number between 1 and 100 (inclusive).");
        System.out.println("I will try to guess it!");

        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (h/l/c)");
            char feedback = getUserFeedback();

            switch (feedback) {
                case 'h':
                    high = guess - 1;
                    break;
                case 'l':
                    low = guess + 1;
                    break;
                case 'c':
                    guessedCorrectly = true;
                    System.out.println("Yay! I guessed your number " + guess + " correctly!");
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'h' for high, 'l' for low, or 'c' for correct.");
            }
        }
    }

    private static int generateGuess(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }

    private static char getUserFeedback() {
        return scanner.nextLine().toLowerCase().charAt(0);
    }
}
