import java.util.Scanner;

public class FestivalLuckeyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter your lucky number : ");

            // Check valid number
            if (!sc.hasNextInt()) {
                System.out.println("Please enter NUMBER only!");
                sc.next();  // clear wrong input
                continue;
            }

            int num = sc.nextInt();

            if (num == -1) {
                System.out.println("Lucky Draw Closed.");
                break;
            }

            // SUPER EASY CONDITION:
            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                System.out.println("You WIN a Gift!");
            } else {
                System.out.println("Better luck next time!");
            }
        }

        sc.close();
    }
}
