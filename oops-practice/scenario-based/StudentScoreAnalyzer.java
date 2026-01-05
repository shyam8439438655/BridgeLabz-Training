public class StudentScoreAnalyzer {

    // Method to validate scores
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    // Method to calculate average score
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        int count = 0;

        for (int score : scores) {
            if (isValidScore(score)) {
                sum += score;
                count++;
            } else {
                System.out.println("Invalid score ignored: " + score);
            }
        }

        if (count == 0) return 0; // avoid divide by zero
        return (double) sum / count;
    }

    // Method to find maximum score
    public static int findMax(int[] scores) {
        int max = Integer.MIN_VALUE;

        for (int score : scores) {
            if (isValidScore(score) && score > max) {
                max = score;
            }
        }

        return max;
    }

    // Method to find minimum score
    public static int findMin(int[] scores) {
        int min = Integer.MAX_VALUE;

        for (int score : scores) {
            if (isValidScore(score) && score < min) {
                min = score;
            }
        }

        return min;
    }

    // Main method
    public static void main(String[] args) {
        int[] scores = {85, 92, -5, 76, 101, 67, 45, 89};

        double avg = calculateAverage(scores);
        int highest = findMax(scores);
        int lowest = findMin(scores);

        System.out.println("Average Score: " + avg);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}