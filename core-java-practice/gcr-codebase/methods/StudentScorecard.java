import java.util.Scanner;

public class StudentScorecard {

    // Method to take PCM marks input for all students
    public static int[][] inputPCMMarks(int numStudents, Scanner sc) {
        int[][] marks = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Math

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();
            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();
            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();
        }
        return marks;
    }

    // Method to calculate total, average, percentage
    public static double[][] calculateScores(int[][] marks) {
        int numStudents = marks.length;
        double[][] results = new double[numStudents][3]; // total, average, percentage

        for (int i = 0; i < numStudents; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 digits
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to display scorecard
    public static void displayScorecard(int[][] marks, double[][] results) {
        System.out.println("\nScorecard:");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");

        for (int i = 0; i < marks.length; i++) {
            System.out.print("S" + (i + 1) + "\t");
            System.out.print(marks[i][0] + "\t" + marks[i][1] + "\t\t" + marks[i][2] + "\t");
            System.out.print((int) results[i][0] + "\t" + results[i][1] + "\t" + results[i][2]);
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        int[][] pcmMarks = inputPCMMarks(numStudents, sc);
        double[][] scores = calculateScores(pcmMarks);
        displayScorecard(pcmMarks, scores);

        sc.close();
    }
}