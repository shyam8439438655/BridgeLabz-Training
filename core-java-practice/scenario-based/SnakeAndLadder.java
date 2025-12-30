import java.util.*;

public class SnakeAndLadder {
    public static void main(String[] args) {

        System.out.println("Welcome to Snake and Ladder Game...");

        // USE CASE 1: Start Position = 0
        int player1 = 0;
        int player2 = 0;
        int diceCount = 0;
        boolean gameOver = false;
        Random random = new Random();

        while (!gameOver) {

            // PLAYER 1 TURN
            System.out.println("\nPLAYER 1 TURN");

            // USE CASE 2: Roll Dice
            int dice = 1 + random.nextInt(6);
            System.out.println("Dice Rolled: " + dice);

            // USE CASE 3: No Play / Snake / Ladder
            int option = 1 + random.nextInt(3); // 1-NoPlay, 2-Ladder, 3-Snake
            int move = 1 + random.nextInt(10);

            if (option == 1) {
                System.out.println("NO PLAY");
            } else if (option == 2) {
                System.out.println("LADDER → Move ahead " + move);
                dice += move;
            } else {
                System.out.println("SNAKE → Move back " + move);
                dice -= move;
            }

            // USE CASE 4: Check valid position (0–100)
            int newPos = player1 + dice;
            if (newPos > 100) newPos = player1;
            if (newPos < 0) newPos = 0;

            player1 = newPos;

            System.out.println("Player 1 Position = " + player1);

            // USE CASE 5: Win Check
            if (player1 == 100) {
                System.out.println("\n🎉 Player 1 Wins!");
                gameOver = true;
                break;
            }

            // PLAYER 2 TURN
            System.out.println("\nPLAYER 2 TURN");

            // USE CASE 2: Roll Dice
            dice = 1 + random.nextInt(6);
            System.out.println("Dice Rolled: " + dice);

            // USE CASE 3: No Play / Snake / Ladder
            option = 1 + random.nextInt(3);
            move = 1 + random.nextInt(10);

            if (option == 1) {
                System.out.println("NO PLAY");
            } else if (option == 2) {
                System.out.println("LADDER → Move ahead " + move);
                dice += move;
            } else {
                System.out.println("SNAKE → Move back " + move);
                dice -= move;
            }

            newPos = player2 + dice;
            if (newPos > 100) newPos = player2;
            if (newPos < 0) newPos = 0;

            player2 = newPos;

            System.out.println("Player 2 Position = " + player2);

            if (player2 == 100) {
                System.out.println("\n🎉 Player 2 Wins!");
                gameOver = true;
                break;
            }

            // USE CASE 7: Count dice rolls
            diceCount++;
        }

        System.out.println("\nTotal Dice Rolled = " + diceCount);
    }
}
