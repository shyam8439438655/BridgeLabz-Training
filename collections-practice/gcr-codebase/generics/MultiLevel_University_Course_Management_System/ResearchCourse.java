package MultiLevel_University_Course_Management_System;

// ResearchCourse
public class ResearchCourse implements CourseType {
    String courseName;

    public ResearchCourse(String courseName) {
        this.courseName = courseName;
    }

    public void showEvaluationType() {
        System.out.println(courseName + "Evaluation: Research-Based");
    }
}

