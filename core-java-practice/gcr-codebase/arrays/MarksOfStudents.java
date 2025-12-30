import java.util.Scanner;
public class MarksOfStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking number of students input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // 2D array to store marks for Physics, Chemistry, and Maths
        int[][] marks = new int[numberOfStudents][3];

        // Taking marks input for each student
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            System.out.print("Physics: ");
            marks[i][0] = scanner.nextInt();
            System.out.print("Chemistry: ");
            marks[i][1] = scanner.nextInt();
            System.out.print("Maths: ");
            marks[i][2] = scanner.nextInt();
        }

        // Calculating percentage and grade for each student
        for (int i = 0; i < numberOfStudents; i++) {
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            double percentage = totalMarks / 3.0;

            String grade;
            if (percentage >= 80) {
                grade = "A";
            } else if (percentage >= 70) {
                grade = "B";
            } else if (percentage >= 60) {
                grade = "C";
            } else if (percentage >= 50) {
                grade = "D";
            } else if (percentage >= 40) {
                grade = "E";
            } else {
                grade = "R";
            }

            // Output for each student
            System.out.println("\n----- Result for Student " + (i + 1) + " ");
            System.out.println("Average Marks: " + percentage);
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }
}
