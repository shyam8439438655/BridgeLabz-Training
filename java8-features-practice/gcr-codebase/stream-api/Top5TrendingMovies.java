import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

public class Top5TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("MovieA", 8.5, 2023),
            new Movie("MovieB", 9.0, 2024),
            new Movie("MovieC", 7.8, 2022),
            new Movie("MovieD", 9.2, 2024),
            new Movie("MovieE", 8.9, 2023),
            new Movie("MovieF", 9.5, 2025)
        );

        movies.stream()
              .filter(m -> m.year >= 2023)
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed())
              .limit(5)
              .forEach(m -> System.out.println(m.name + " - " + m.rating));
    }
}