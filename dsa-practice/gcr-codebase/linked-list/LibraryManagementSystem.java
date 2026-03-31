class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean available;   

    Book next;   
    Book prev;  

    // Constructor
    Book(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;   
    Book tail;   

    //  Add book at beginning
    void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);

        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    //  Add book at end
    void addAtEnd(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);

        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    //  Add book at specific position (1-based)
    void addAtPosition(int position, int id, String title, String author, String genre, boolean available) {

        if (position == 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }

        Book temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp == tail) {
            addAtEnd(id, title, author, genre, available);
            return;
        }

        Book newBook = new Book(id, title, author, genre, available);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    //  Remove book by Book ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed successfully");
    }

    //  Search book by title
    void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }

    //  Search book by author
    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }

    //  Update availability status
    void updateAvailability(int id, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }

    //  Display books forward
    void displayForward() {
        if (head == null) {
            System.out.println("No books to display");
            return;
        }

        Book temp = head;
        System.out.println("Books (Forward):");
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    //  Display books backward
    void displayBackward() {
        if (tail == null) {
            System.out.println("No books to display");
            return;
        }

        Book temp = tail;
        System.out.println("Books (Reverse):");
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    void countBooks() {
        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total books in library = " + count);
    }

    void printBook(Book b) {
        System.out.println("---------------------");
        System.out.println("Book ID    : " + b.bookId);
        System.out.println("Title      : " + b.title);
        System.out.println("Author     : " + b.author);
        System.out.println("Genre      : " + b.genre);
        System.out.println("Available  : " + (b.available ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library lib = new Library();

        lib.addAtBeginning(101, "Java Basics", "James", "Programming", true);
        lib.addAtEnd(102, "Python Guide", "Guido", "Programming", true);
        lib.addAtEnd(103, "Data Structures", "Mark", "CS", false);

        lib.displayForward();
        lib.displayBackward();

        lib.searchByAuthor("Guido");
        lib.updateAvailability(103, true);
        lib.removeById(101);

        lib.displayForward();
        lib.countBooks();
    }
}
