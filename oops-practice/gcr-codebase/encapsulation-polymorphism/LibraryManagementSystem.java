interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    // sensitive detail encapsulated
    private String borrowerName;
    private boolean isReserved;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // encapsulated sensitive info
    protected String getBorrowerName() {
        return borrowerName;
    }

    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    protected void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }

    protected boolean getReserved() {
        return isReserved;
    }

    // abstract method
    public abstract int getLoanDuration();

    // concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId +
                           ", Title: " + title +
                           ", Author: " + author +
                           ", Loan Duration: " + getLoanDuration() + " days");
    }
}

// Book class
class Book extends LibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // Books: 14 days loan
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!getReserved()) {
            setBorrowerName(borrowerName);
            setReserved(true);
            System.out.println("Book reserved by: " + borrowerName);
        } else {
            System.out.println("Book already reserved by: " + getBorrowerName());
        }
    }

    @Override
    public boolean checkAvailability() {
        return !getReserved();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // Magazines: 7 days loan
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!getReserved()) {
            setBorrowerName(borrowerName);
            setReserved(true);
            System.out.println("Magazine reserved by: " + borrowerName);
        } else {
            System.out.println("Magazine already reserved by: " + getBorrowerName());
        }
    }

    @Override
    public boolean checkAvailability() {
        return !getReserved();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // DVDs: 3 days loan
        return 3;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!getReserved()) {
            setBorrowerName(borrowerName);
            setReserved(true);
            System.out.println("DVD reserved by: " + borrowerName);
        } else {
            System.out.println("DVD already reserved by: " + getBorrowerName());
        }
    }

    @Override
    public boolean checkAvailability() {
        return !getReserved();
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book(101, "Java Programming", "James Gosling");
        LibraryItem item2 = new Magazine(102, "Tech Monthly", "Editorial Team");
        LibraryItem item3 = new DVD(103, "Inception", "Christopher Nolan");

        LibraryItem[] items = {item1, item2, item3};

        for (LibraryItem item : items) {
            item.getItemDetails();
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("Shyam");
                System.out.println("Available after reservation: " + r.checkAvailability());
            }
            System.out.println("-------------------------");
        }
    }
}