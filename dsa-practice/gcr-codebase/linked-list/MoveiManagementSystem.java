class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie next;   
    Movie prev;   

    // Constructor
    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head;   // first movie
    Movie tail;   // last movie

    //  Add movie at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {          // list is empty
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    //  Add movie at end
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) {          // list is empty
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    //  Add movie at specific position (1-based)
    void addAtPosition(int position, String title, String director, int year, double rating) {

        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp == tail) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    //  Remove movie by title
    void removeByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty");
            return;
        }

        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
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

        System.out.println("Movie removed successfully");
    }

    //  Search movie by director
    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found for this director");
        }
    }

    //  Search movie by rating
    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found with this rating");
        }
    }

    //  Update rating by movie title
    void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    //  Display movies forward
    void displayForward() {
        if (head == null) {
            System.out.println("No movies to display");
            return;
        }

        Movie temp = head;
        System.out.println("Movies (Forward):");
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    //  Display movies backward
    void displayBackward() {
        if (tail == null) {
            System.out.println("No movies to display");
            return;
        }

        Movie temp = tail;
        System.out.println("Movies (Reverse):");
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    
    void printMovie(Movie m) {
        System.out.println("            ");
        System.out.println("Title   : " + m.title);
        System.out.println("Director: " + m.director);
        System.out.println("Year    : " + m.year);
        System.out.println("Rating  : " + m.rating);
    }
}

public class MoveiManagementSystem {
    public static void main(String[] args) {

        MovieList list = new MovieList();

        list.addAtBeginning("Inception", "Nolan", 2010, 8.8);
        list.addAtEnd("Interstellar", "Nolan", 2014, 8.6);
        list.addAtEnd("Titanic", "Cameron", 1997, 7.9);

        list.displayForward();
        list.displayBackward();

        list.searchByDirector("Nolan");
        list.updateRating("Titanic", 8.0);
        list.removeByTitle("Inception");

        list.displayForward();
    }
}
