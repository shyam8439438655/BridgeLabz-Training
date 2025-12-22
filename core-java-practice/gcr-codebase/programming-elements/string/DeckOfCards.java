import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize deck
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                          "Jack", "Queen", "King", "Ace"};

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];// array to hold cards

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Method to shuffle deck
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            // swap
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Method to distribute cards
    public static String[][] distributeCards(String[] deck, int n, int players) {
        if (n % players != 0) {
            System.out.println("Cards cannot be evenly distributed!");
            return null;
        }

        int cardsPerPlayer = n / players;
        String[][] result = new String[players][cardsPerPlayer];

        int index = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                result[i][j] = deck[index++];
            }
        }
        return result;
    }

    // Method to print players and their cards
    public static void printPlayers(String[][] players) {
        if (players == null) return;
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize deck
        String[] deck = initializeDeck();

        // Shuffle deck
        shuffleDeck(deck);

        // Take user input
        System.out.print("Enter number of cards to distribute: ");
        int n = input.nextInt();

        System.out.print("Enter number of players: ");
        int players = input.nextInt();

        // Distribute
        String[][] distributed = distributeCards(deck, n, players);

        // Print result
        printPlayers(distributed);

        input.close();
    }
}