package Smart_University_Library_Management_System;

// Factory
public class Factory {

    public static User createUser(String role, String name, String bookInterest) {

        if (role.equalsIgnoreCase("student")) {
            return new Student(name, bookInterest);
        } 
        else if (role.equalsIgnoreCase("faculty")) {
            return new Faculty(name, bookInterest);
        } 
        else if (role.equalsIgnoreCase("librarian")) {
            return new Librarian(name);
        } 
        else {
            throw new IllegalArgumentException("Invalid Role");
        }
    }
}

// -------- User Interface --------
interface User {
    void showPrivileges();
}

// -------- Concrete Users --------
class Student implements User, Observer {
    String name;
    String bookInterest;

    Student(String name, String bookInterest) {
        this.name = name;
        this.bookInterest = bookInterest;
    }

    public void showPrivileges() {
        System.out.println("Student: Limited borrowing days");
    }

    public void update(String bookName) {
        if (bookName.equalsIgnoreCase(bookInterest)) {
            System.out.println("Notification to Student " + name + 
                ": Book available -> " + bookName);
        }
    }
}

class Faculty implements User, Observer {
    String name;
    String bookInterest;

    Faculty(String name, String bookInterest) {
        this.name = name;
        this.bookInterest = bookInterest;
    }

    public void showPrivileges() {
        System.out.println("Faculty: Extended borrowing days");
    }

    public void update(String bookName) {
        if (bookName.equalsIgnoreCase(bookInterest)) {
            System.out.println("Notification to Faculty " + name + 
                ": Book available -> " + bookName);
        }
    }
}

class Librarian implements User {
    String name;

    Librarian(String name) {
        this.name = name;
    }

    public void showPrivileges() {
        System.out.println("Librarian: Manages inventory");
    }
}

