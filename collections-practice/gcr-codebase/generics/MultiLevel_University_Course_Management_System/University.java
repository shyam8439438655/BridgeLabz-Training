package MultiLevel_University_Course_Management_System;

// UniversityMain.java
public class University{
    public static void main(String[] args) {

        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse("DSA"));
        examDept.addCourse(new ExamCourse("DBMS"));

        Course<AssignmentCourse> assignmentDept = new Course<>();
        assignmentDept.addCourse(new AssignmentCourse("Web Development"));
        assignmentDept.addCourse(new AssignmentCourse("Java Project"));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse("AI Research"));
        researchDept.addCourse(new ResearchCourse("Cyber Security Research"));

        System.out.println("Exam Courses:");
        CourseUtil.showAllCourses(examDept.getCourses());

        System.out.println("\nAssignment Courses:");
        CourseUtil.showAllCourses(assignmentDept.getCourses());

        System.out.println("\nResearch Courses:");
        CourseUtil.showAllCourses(researchDept.getCourses());
    }
}

