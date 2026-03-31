class Book{
    String title;
    String author;
    String price;
    //Provide both default and parameterized constructors.
    Book(){
        title = "";
        author = "";
        price = "";
    }

    Book(String title , String author, String price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
public class BookDetails {
    public static void main(String[] args){
        //Create objects using both constructors and display the details.
        Book book1 = new Book();
        System.out.println("Default Book Details:");
        book1.displayDetails();
        System.out.println(); // Just for better readability
        Book book2 = new Book("1984", "George Orwell",  "10");
        System.out.println("Parameterized Book Details:");
        book2.displayDetails();
    }
}