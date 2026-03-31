package MultiLevel_University_Course_Management_System;

// CourseUtil
import java.util.List;

public class CourseUtil {

    // Wildcard method (accepts any CourseType list)
    public static void showAllCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            c.showEvaluationType();
        }
    }
}

