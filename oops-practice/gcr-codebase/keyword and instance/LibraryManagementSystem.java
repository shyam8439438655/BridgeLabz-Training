class Book {
    // Static variable shared by all books
    static String libraryName = "Egmore Library";

    // Final variable for unique identifier
    final String isbn;

    // Instance variables
    String title;
    String author;

    // Constructor using 'this'
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Display details only if object is Book
    void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    } 
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book.displayLibraryName();
        Book b1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        b1.displayDetails();
    }
}