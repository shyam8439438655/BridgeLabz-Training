import java.util.Scanner;
public class AgeOffAllStudents {
    // Method to check if a student can vote
    public static boolean canStudentVote(int age) {
        // Validate for negative age
        if (age < 0) {
            return false;
        }
        // Check if age is 18 or above
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        // Taking user input for ages of 10 students
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }
        // Checking and displaying if each student can vote
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = canStudentVote(ages[i]);
            if (canVote) {
                System.out.println("Student " + (i + 1) + " with age " + ages[i] + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + ages[i] + " cannot vote.");
            }
        }
        scanner.close();
    }
}