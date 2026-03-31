class Book {
    // Public member
    public String ISBN;

    // Protected member (accessible in subclasses)
    protected String title;

    // Private member (only accessible inside Book class)
    private String author;

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get author
    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: EBook
class EBook extends Book {
    private double fileSizeMB;

    // Constructor
    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        // Call parent constructor
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    // Demonstrating access to public (ISBN) and protected (title)
    public void displayEBookInfo() {
        System.out.println("EBook ISBN (public): " + ISBN);
        System.out.println("EBook Title (protected): " + title);
        System.out.println("EBook Author (via getter): " + getAuthor());
        System.out.println("File Size: " + fileSizeMB + " MB");
    }
}

// Main class to test
public class BookLibrarySystem {
    public static void main(String[] args) {
        // Create a Book object
        Book b1 = new Book("978-1234567890", "Java Basics", "James Gosling");
        b1.displayBookInfo();

        // Modify author using setter
        b1.setAuthor("Updated Author");
        System.out.println("Updated Author: " + b1.getAuthor());

        System.out.println("-----------------------------");

        // Create an EBook object
        EBook eb1 = new EBook("978-0987654321", "Advanced Java", "Herbert Schildt", 5.2);
        eb1.displayEBookInfo();
    }
}