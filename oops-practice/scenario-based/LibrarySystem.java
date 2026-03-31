class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    void display() {
        String status = isAvailable ? "Available" : "Checked Out";
        System.out.println(title + " - " + author + " - " + status);
    }
}

public class LibrarySystem {
    static Book[] books = {
        new Book("Harry Potter", "J.K. Rowling", true),
        new Book("The Hobbit", "J.R.R. Tolkien", true),
        new Book("Clean Code", "Robert C. Martin", false)
    };

    // Search by partial title
    static void searchBook(String keyword) {
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                b.display();
            }
        }
    }

    // Checkout a book
    static void checkoutBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("Book checked out: " + b.title);
                } else {
                    System.out.println("Book already checked out!");
                }
            }
        }
    }

    // Display all books
    static void displayAllBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    public static void main(String[] args) {
        searchBook("Harry");
        checkoutBook("Harry Potter");
        displayAllBooks();
    }
}