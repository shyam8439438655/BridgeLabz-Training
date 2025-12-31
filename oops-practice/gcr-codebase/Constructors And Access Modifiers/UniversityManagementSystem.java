class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    
    // parameterized constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

        // Public method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to set CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Display student details
    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }

    // Subclass: PostgraduateStudent
class PostgraduateStudent extends Student {
    private String specialization;

    // Constructor
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        // Call parent constructor
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    // Demonstrating access to protected member 'name'
    public void displayPostgraduateInfo() {
        System.out.println("Postgraduate Student Name (protected): " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("CGPA (via getter): " + getCGPA());
    }
}

}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create Student object
        Student student1 = new Student(101, "Alice", 9.1);
        System.out.println("Student Details:");
        student1.displayStudentInfo();
        System.out.println(); // Just for better readability

        // Create PostgraduateStudent object
        PostgraduateStudent pgStudent1 = new PostgraduateStudent();
        System.out.println("Postgraduate Student Details:");
        pgStudent1.displayStudentInfo();
        pgStudent1.displayPostgraduateInfo();
    }
}
