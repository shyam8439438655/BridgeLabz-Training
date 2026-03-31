import java.util.*;

// Exam Proctor System
public class ExamProctor {

    // last visited question track 
    Stack<Integer> navigation = new Stack<>();

    // questionId -> answer
    HashMap<Integer, String> answers = new HashMap<>();

    // correct answers 
    HashMap<Integer, String> correct = new HashMap<>();

    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();

        // correct answers set
        exam.correct.put(1, "A");
        exam.correct.put(2, "B");
        exam.correct.put(3, "C");

        // student navigation
        exam.visitQuestion(1);
        exam.answerQuestion(1, "A");

        exam.visitQuestion(2);
        exam.answerQuestion(2, "C");

        exam.visitQuestion(3);
        exam.answerQuestion(3, "C");

        // submit exam
        exam.submit();
    }

    // question visit
    void visitQuestion(int qid) {
        navigation.push(qid);
        System.out.println("Visited Question " + qid);
    }

    // answer store
    void answerQuestion(int qid, String ans) {
        answers.put(qid, ans);
        System.out.println("Answered Q" + qid + " -> " + ans);
    }

    // scoring logic
    int calculateScore() {
        int score = 0;

        for (int qid : correct.keySet()) {
            if (answers.containsKey(qid)) {
                if (answers.get(qid).equals(correct.get(qid))) {
                    score++;
                }
            }
        }
        return score;
    }

    // submit exam
    void submit() {
        System.out.println("\nLast Visited Question: " + navigation.peek());
        int totalScore = calculateScore();
        System.out.println("Final Score: " + totalScore);
    }
}
