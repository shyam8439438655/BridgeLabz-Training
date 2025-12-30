class Book {
    
    String title;
    String author;
    double price;

    // Constructor to initialize book details
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}

// Main class
public class BookDetails {
    public static void main(String[] args) {
        // Create two Book objects
        Book book1 = new Book("2States", "Chetan Bhagat", 500.0);
        Book book2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);

        // Display details of both books
        book1.displayDetails();
        System.out.println(); 
        book2.displayDetails();
    }
}