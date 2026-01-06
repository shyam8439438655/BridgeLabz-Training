import java.util.ArrayList;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String msg) {
        super(msg);
    }
}

public class OnlineQuizPlatform {

    // store scores of multiple users
    static ArrayList<Integer> scores = new ArrayList<>();

    // compare answers and calculate score
    static int calculateScore(String[] correctAnswers, String[] userAnswers) {

        // validation: length mismatch
        if (correctAnswers.length != userAnswers.length) {
            System.out.println("Error: Number of answers does not match questions");
            return 0;  // score 0 if invalid
        }

        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }

        return score;
    }

    // return grade based on score
    static String getGrade(int score, int totalQuestions) {

        int percentage = (score * 100) / totalQuestions;

        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 40) {
            return "C";
        } else {
            return "Fail";
        }
    }

    // process user quiz (handle exception inside)
    static void processUserQuiz(String[] correctAnswers, String[] userAnswers) {

        int score = calculateScore(correctAnswers, userAnswers);
        scores.add(score);  // store score

        String grade = getGrade(score, correctAnswers.length);

        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        String[] correctAnswers = {"A", "B", "C", "D", "A"};
        String[] user1Answers   = {"A", "B", "C", "A", "A"};
        String[] user2Answers   = {"A", "B", "C", "D", "A"};

        processUserQuiz(correctAnswers, user1Answers);
        System.out.println("------");
        processUserQuiz(correctAnswers, user2Answers);

        System.out.println("All Scores: " + scores);
    }
}
