import java.util.ArrayList;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

// Book class
class Book {
    String title;
    String author;
    boolean isAvailable; // true = available, false = checked out

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // default available
    }
}

public class LibraryManagementSystem {

    // Store books in a list
    static ArrayList<Book> books = new ArrayList<>();

    // Add book
    static void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title);
    }

    // Search books by partial title
    static void searchBook(String keyword) {
        boolean found = false;
        System.out.println("Search results for: " + keyword);
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("- " + b.title + " by " + b.author +
                        " [" + (b.isAvailable ? "Available" : "Checked Out") + "]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching: " + keyword);
        }
    }

    // Checkout book
    static void checkoutBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("You have successfully checked out: " + b.title);
                    return;
                } else {
                    System.out.println("Error: Book is not available!");
                    return;
                }
            }
        }
        System.out.println("Book not found: " + title);
    }

    // Display all books
    static void displayBooks() {
        System.out.println("Library Books:");
        for (Book b : books) {
            System.out.println("- " + b.title + " by " + b.author +
                    " [" + (b.isAvailable ? "Available" : "Checked Out") + "]");
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // Adding books
        addBook("Harry Potter", "J.K. Rowling");
        addBook("The Hobbit", "J.R.R. Tolkien");
        addBook("The Alchemist", "Paulo Coelho");
        addBook("Java Programming", "John Doe");

        System.out.println("\n--- Display all books ---");
        displayBooks();

        System.out.println("\n--- Search books with 'the' ---");
        searchBook("the");

        System.out.println("\n--- Checkout a book ---");
        checkoutBook("The Hobbit");   // available
        checkoutBook("The Hobbit");   // already checked out

        System.out.println("\n--- Display all books after checkout ---");
        displayBooks();
    }
}
