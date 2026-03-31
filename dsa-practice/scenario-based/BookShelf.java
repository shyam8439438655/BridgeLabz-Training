import java.util.*;

public class BookShelf {

    HashMap<String, LinkedList<String>> catalog = new HashMap<>();

    // optional: duplicate avoid krne ke liye
    HashSet<String> allBooks = new HashSet<>();

    public static void main(String[] args) {
        BookShelf lib = new BookShelf();

        lib.addBook("Fiction", "Harry Potter");
        lib.addBook("Fiction", "Harry Potter"); // duplicate, add nhi hoga
        lib.addBook("Fiction", "Alchemist");
        lib.addBook("Tech", "Java Basics");

        lib.display();

        lib.borrowBook("Fiction", "Alchemist");
        lib.display();

        lib.returnBook("Fiction", "Alchemist");
        lib.display();
    }

    // book add krne ke liye
    void addBook(String genre, String bookName) {

        // duplicate check
        if (allBooks.contains(bookName)) {
            System.out.println(bookName + " already present");
            return;
        }

        // agar genre pehle se nahi hai
        if (!catalog.containsKey(genre)) {
            catalog.put(genre, new LinkedList<>());
        }

        catalog.get(genre).add(bookName);
        allBooks.add(bookName);

        System.out.println(bookName + " added in " + genre);
    }

    // book borrow (remove)
    void borrowBook(String genre, String bookName) {

        if (catalog.containsKey(genre)) {
            LinkedList<String> list = catalog.get(genre);

            if (list.remove(bookName)) {
                allBooks.remove(bookName);
                System.out.println(bookName + " borrowed");
            } else {
                System.out.println(bookName + " not found");
            }
        }
    }

    // book return (add back)
    void returnBook(String genre, String bookName) {
        addBook(genre, bookName);
    }

    // display catalog
    void display() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println(genre + " -> " + catalog.get(genre));
        }
    }
}
