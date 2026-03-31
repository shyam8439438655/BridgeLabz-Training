import java.util.ArrayList;

// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String msg) {
        super(msg);
    }
}

// Student class to store name and marks
class Student {
    String name;
    int[] marks;  // marks for subjects

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentReportGenerator {

    static ArrayList<Student> students = new ArrayList<>();

    // Add student (validate marks inside)
    static void addStudent(String name, int[] marks) {

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Error: Marks should be between 0 and 100 for student " + name);
                return;
            }
        }

        students.add(new Student(name, marks));
        System.out.println("Student " + name + " added successfully");
    }

    // Calculate average marks
    static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    // Assign grade based on average
    static String getGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else return "Fail";
    }

    // Display report card
    static void displayReport(Student s, String[] subjects) {

        System.out.println("=======================================");
        System.out.println("Report Card for: " + s.name);
        System.out.println("---------------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + s.marks[i]);
        }

        double avg = calculateAverage(s.marks);
        String grade = getGrade(avg);

        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Grade: " + grade);
        System.out.println("=======================================\n");
    }

    // MAIN method 
    public static void main(String[] args) {

        String[] subjects = {"Math", "Science", "English", "History"};

        int[] marks1 = {95, 85, 76, 88};
        int[] marks2 = {45, 60, 72, 55};
        int[] marks3 = {105, 90, 80, 70};  // invalid marks

        addStudent("Aman", marks1);
        addStudent("Ravi", marks2);
        addStudent("Karan", marks3);  // will show error

        // display all report cards
        for (Student s : students) {
            displayReport(s, subjects);
        }
    }
}
