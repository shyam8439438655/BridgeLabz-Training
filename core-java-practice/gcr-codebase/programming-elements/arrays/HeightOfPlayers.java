import java.util.Scanner;
public class HeightOfPlayers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        // Taking user input for heights of 11 players
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter the height of player " + (i + 1) + " in meters: ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        // Calculating mean height
        double meanHeight = sum / heights.length;
        System.out.printf("The mean height of the football team is: %.2f meters%n ", meanHeight);
        scanner.close();
    }
}
