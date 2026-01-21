package MultiLevel_University_Course_Management_System;

// ExamCourse.java
public class ExamCourse implements CourseType {
    String courseName;

    public ExamCourse(String courseName) {
        this.courseName = courseName;
    }

    public void showEvaluationType() {
        System.out.println(courseName + "Evaluation: Exam-Based");
    }
}

