package MultiLevel_University_Course_Management_System;

// Course
import java.util.ArrayList;
import java.util.List;

public class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}

