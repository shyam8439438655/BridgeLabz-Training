import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) // Infinite loop to continuously accept voters
        {

            System.out.print("Enter age : ");
            int age = sc.nextInt();

            // Exit condition
            if (age == -1) {
                System.out.println("Voting Closed. Thank you!");
                break;
            }

            // Check eligibility
            if (age >= 18) {
                System.out.println("You are eligible to vote.");

                System.out.println("Please record your vote:");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                System.out.print("Enter your vote (1/2/3): ");
                int vote = sc.nextInt();

                if (vote == 1 || vote == 2 || vote == 3) {
                    System.out.println("Your vote has been recorded.\n");
                } else {
                    System.out.println("Invalid vote! Try again.\n");
                }

            } else {
                System.out.println("You are NOT eligible to vote.\n");
            }
        }

        sc.close();
    }
}
