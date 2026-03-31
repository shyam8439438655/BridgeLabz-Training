import java.util.Scanner;
public class Markss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking marks input
        System.out.print("Enter Physics marks: ");
        int physics = scanner.nextInt();

        System.out.print("Enter Chemistry marks: ");
        int chemistry = scanner.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = scanner.nextInt();

        // Calculating total and percentage
        int totalMarks = physics + chemistry + maths;
        double percentage = totalMarks / 3.0;

        String grade;
        String remarks;

        // Grade calculation
        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Level 2, below but approaching standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level 1-, too below standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        // Output
        System.out.println("\n----- Result -----");
        System.out.println("Average Marks: " + percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        scanner.close();
    } 
}
