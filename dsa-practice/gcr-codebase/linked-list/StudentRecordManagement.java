class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;   // link to next student

    // Constructor
    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Student head;   // first student in the list

    //  Add student at beginning
    void addAtBeginning(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    //  Add student at end
    void addAtEnd(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);

        if (head == null) {   // list empty
            head = newStudent;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    //  Add student at specific position 
    void addAtPosition(int position, int rollNo, String name, int age, String grade) {
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    //  Delete student by roll number
    void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }

    //  Search student by roll number
    void searchByRollNo(int rollNo) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    //  Update grade by roll number
    void updateGrade(int rollNo, String newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    //  Display all students
    void displayAll() {
        if (head == null) {
            System.out.println("No student records");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("         ");
            System.out.println("Roll No: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {

        StudentList list = new StudentList();

        // Adding students
        list.addAtBeginning(1, "Aman", 20, "A");
        list.addAtEnd(2, "Ravi", 21, "B");
        list.addAtEnd(3, "Neha", 19, "A+");

        // Display all
        list.displayAll();

        // Search student
        list.searchByRollNo(2);

        // Update grade
        list.updateGrade(2, "A");

        // Delete student
        list.deleteByRollNo(1);

        // Display again
        list.displayAll();
    }
}
