class Course {
    String courseName;
    String duration;
    int fee;
    // class variable
    static int instituteNames = 0;

    // parameterized constructor
    Course(String courseName, String duration, int fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
        instituteNames++; // incrementing the class variable
    }
    // instance method to display course details
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: $" + fee);
    }
    // class method to display total institutes
    static void displayTotalInstitutes() {
        System.out.println("Total Institutes Offering Courses: " + instituteNames);
    }

}

public class OnlineCourseManagement {
    public static void main(String[] args) {
        // Create course objects
        Course course1 = new Course("Java Programming", "3 Months", 1500);
        Course course2 = new Course("Web Development", "4 Months", 1800);

        // Display course details
        System.out.println("Course 1 Details:");
        course1.displayCourseDetails();
        System.out.println(); // Just for better readability

        System.out.println("Course 2 Details:");
        course2.displayCourseDetails();
        System.out.println(); // Just for better readability

        // Display total institutes
        Course.displayTotalInstitutes();
    }
}
