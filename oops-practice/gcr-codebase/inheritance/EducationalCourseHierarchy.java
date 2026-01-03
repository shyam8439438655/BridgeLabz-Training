class Course {
    String courseName;
    int duration; // duration in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    String getCourseInfo() {
        return "Course: " + courseName + ", Duration: " + duration + " hours";
    }
}
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    String getCourseInfo() {
        return super.getCourseInfo() + ", Platform: " + platform + ", Recorded: " + isRecorded;
    }
}
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // discount in percentage

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    String getCourseInfo() {
        double discountedFee = fee - (fee * discount / 100);
        return super.getCourseInfo() + ", Fee: $" + fee + ", Discount: " + discount + "%, Discounted Fee: $" + discountedFee;
    }
}
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course course = new Course("Introduction to Programming", 40);
        System.out.println(course.getCourseInfo());

        OnlineCourse onlineCourse = new OnlineCourse("Data Structures", 50, "Udemy", true);
        System.out.println(onlineCourse.getCourseInfo());

        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Advanced Java", 60, "Coursera", false, 200.0, 15.0);
        System.out.println(paidOnlineCourse.getCourseInfo());
    }
}
