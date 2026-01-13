class ExamTimeExpiredException extends RuntimeException {
    public ExamTimeExpiredException(String message) {
        super(message);
    }
}

// Interface for Evaluation Strategy
interface EvaluationStrategy {
    int evaluate(String[] answers, String[] correctAnswers);
}

// Objective Evaluation for mcq
class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(String[] answers, String[] correctAnswers) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }
        return score;
    }
}

// Student Class
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

// Question Class
class Question {
    String questionText;
    String[] options; // For MCQs
    String correctAnswer;

    Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

// Exam Class
class Exam {
    String title;
    Question[] questions;
    boolean isActive = true; // Exam available or expired

    Exam(String title, Question[] questions) {
        this.title = title;
        this.questions = questions;
    }

    public void submitAnswers(Student student, String[] answers, EvaluationStrategy strategy) throws ExamTimeExpiredException {
        if (!isActive) {
            throw new ExamTimeExpiredException("Exam time is over! Cannot submit answers.");
        }
        int score = strategy.evaluate(answers, getCorrectAnswers());
        System.out.println(student.name + " scored: " + score + " out of " + questions.length);
    }

    private String[] getCorrectAnswers() {
        String[] correctAnswers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            correctAnswers[i] = questions[i].correctAnswer;
        }
        return correctAnswers;
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        // Create Questions
        Question q1 = new Question("What is 2 + 2?", new String[]{"1", "2", "3", "4"}, "4");
        Question q2 = new Question("Capital of India?", new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, "Delhi");
        Question[] questions = {q1, q2};

        // Create Exam
        Exam mathExam = new Exam("General Knowledge", questions);

        // Create Student
        Student student = new Student("Shyam");

        // Student answers
        String[] studentAnswers = {"4", "Delhi"};

        // Evaluation
        EvaluationStrategy strategy = new ObjectiveEvaluation();

        try {
            mathExam.submitAnswers(student, studentAnswers, strategy);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }

        // Simulate exam expiration
        mathExam.isActive = false;

        try {
            mathExam.submitAnswers(student, studentAnswers, strategy); // Will throw exception
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
