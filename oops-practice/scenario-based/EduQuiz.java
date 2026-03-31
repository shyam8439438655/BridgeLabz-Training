import java.util.Scanner;

public class EduQuiz {
    
    // Method to calculate score
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                score++;
                System.out.println("Question " + (i+1) + ": Correct");
            } else {
                System.out.println("Question " + (i+1) + ": Incorrect (Correct Answer: " + correct[i] + ")");
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Correct answers (10 questions)
        String[] correctAnswers = {
            "A", "C", "B", "D", "A", "B", "C", "D", "A", "B"
        };

        // Student answers array
        String[] studentAnswers = new String[10];

        System.out.println("Welcome to EduQuiz!");
        System.out.println("Please enter your answers (A/B/C/D) for 10 questions:");

        // Take user input
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print("Answer for Question " + (i+1) + ": ");
            studentAnswers[i] = sc.nextLine();
        }

        // Calculate score
        int score = calculateScore(correctAnswers, studentAnswers);

        // Show results
        System.out.println("\nFinal Score: " + score + " out of " + correctAnswers.length);

        // Bonus: Percentage and Pass/Fail
        double percentage = (score * 100.0) / correctAnswers.length;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50) {
            System.out.println("Result: PASS 🎉");
        } else {
            System.out.println("Result: FAIL ❌");
        }

        sc.close();
    }
}