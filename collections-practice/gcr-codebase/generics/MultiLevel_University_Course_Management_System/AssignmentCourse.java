package MultiLevel_University_Course_Management_System;

// AssignmentCourse
public class AssignmentCourse implements CourseType {
    String courseName;

    public AssignmentCourse(String courseName) {
        this.courseName = courseName;
    }

    public void showEvaluationType() {
        System.out.println(courseName + "Evaluation: Assignment-Based");
    }
}
