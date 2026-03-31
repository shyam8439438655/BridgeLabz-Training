// Abstraction
interface RegistrationService {
    void enrollCourse(String course) throws CourseLimitExceededException;
    void dropCourse();
    void viewDetails();
}

// Exception Handling
class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String msg) {
        super(msg);
    }
}

class Person {
    protected String name;
    protected int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}

// Child class
class Student extends Person implements RegistrationService {

    private String course;
    private int grade;
    private final int COURSE_LIMIT = 1;

    Student(String name, int id) {
        super(name, id);
    }

    // Enroll course
    public void enrollCourse(String course) throws CourseLimitExceededException {
        if (this.course != null) {
            throw new CourseLimitExceededException("Only one course allowed!");
        }
        this.course = course;
        System.out.println("Course enrolled: " + course);
    }

    // Drop course
    public void dropCourse() {
        if (course == null) {
            System.out.println("No course to drop");
        } else {
            System.out.println("Course dropped: " + course);
            course = null;
        }
    }

    // Set grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // View details
    public void viewDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
    }
}

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {

        Student s1 = new Student("Rahul", 101);

        try {
            s1.enrollCourse("Java");
            s1.enrollCourse("Python"); // Exception
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        s1.setGrade(85);
        s1.viewDetails();

        s1.dropCourse();
        s1.viewDetails();
    }
}
