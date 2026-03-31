class Book{
    String title;
    String author;
    String price;
    String availability;
    // default constructor
    Book(){
        title = "";
        author = "";
        price = "";
        availability = "Available";
    }
    // parameterized constructor
    Book(String title , String author, String price, String availability){
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }
    // copy constructor
    Book(Book b){
        this.title = b.title;
        this.author = b.author;
        this.price = b.price;
        this.availability = b.availability;
    }

    void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + availability);
    }
}
public class LibraryBookSystem {
    public static void main(String[] args) {
        // Create object using default constructor
        Book book1 = new Book();
        System.out.println("Default Book Details:");
        book1.displayDetails();
        System.out.println(); // Just for better readability

        // Create object using parameterized constructor
        Book book2 = new Book("Gaban Aur Godan", "Munshii Premchand", "250", "Checked Out");
        System.out.println("Parameterized Book Details:");
        book2.displayDetails();
        System.out.println(); // Just for better readability

        // Create object using copy constructor
        Book book3 = new Book(book2);
        System.out.println("Copy of Parameterized Book Details:");
        book3.displayDetails();
    }
}
