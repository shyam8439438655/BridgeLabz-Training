import java.util.*;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String genre;
    private int pages;

    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

public class BookStatsByGenre {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Atomic Habits", "Self-Help", 320),
                new Book("Deep Work", "Self-Help", 280),
                new Book("Harry Potter", "Fiction", 450),
                new Book("The Hobbit", "Fiction", 310),
                new Book("Java Basics", "Education", 500)
        );

        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)   // ✅ as you said
                ));

        // total, average, max per genre
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println("____");
        });
    }
}
