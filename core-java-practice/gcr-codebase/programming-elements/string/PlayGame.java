import java.util.Scanner;

public class PlayGame {

    // Method to get computer choice using Math.random
    public static String getComputerChoice() {
        int num = (int)(Math.random() * 3); // 0,1,2
        if (num == 0) return "rock";
        else if (num == 1) return "paper";
        else return "scissors";
    }

    // Method to find winner between user and computer
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        }
        if (user.equals("rock") && computer.equals("scissors")) return "User";
        if (user.equals("rock") && computer.equals("paper")) return "Computer";
        if (user.equals("paper") && computer.equals("rock")) return "User";
        if (user.equals("paper") && computer.equals("scissors")) return "Computer";
        if (user.equals("scissors") && computer.equals("paper")) return "User";
        if (user.equals("scissors") && computer.equals("rock")) return "Computer";
        return "Invalid";
    }

    // Method to calculate average and percentage wins
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf((userWins * 100) / totalGames) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf((computerWins * 100) / totalGames) + "%";

        return stats;
    }

    // Method to display results of each game and final stats
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame\tUser Choice\tComputer Choice\tWinner");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i+1) + "\t" + gameResults[i][0] + "\t\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }

        System.out.println("\nFinal Stats:");
        System.out.println("Player\tWins\tWin %");
        System.out.println("---------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for number of games
        System.out.print("Enter number of games to play: ");
        int n = sc.nextInt();

        String[][] gameResults = new String[n][3];
        int userWins = 0, computerWins = 0;

        // Play n games
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter your choice (rock/paper/scissors): ");
            String userChoice = sc.next().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        // Calculate stats
        String[][] stats = calculateStats(userWins, computerWins, n);

        // Display results
        displayResults(gameResults, stats);

        sc.close();
    }
}