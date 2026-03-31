import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String msg) {
        super(msg);
    }
}

public class CinemaTime {

    // List for movie titles
    private List<String> titles = new ArrayList<>();

    // List for showtimes
    private List<String> times = new ArrayList<>();

    // add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        // simple time validation HH:MM
        if (!time.matches("([01][0-9]|2[0-3]):[0-5][0-9]")) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        titles.add(title);
        times.add(time);
    }

    // search movie using keyword
    public void searchMovie(String keyword) {
        try {
            for (int i = 0; i < titles.size(); i++) {
                if (titles.get(i).contains(keyword)) {
                    System.out.println("Found: " + titles.get(i) + " at " + times.get(i));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index accessed");
        }
    }

    // display all movies
    public void displayAllMovies() {
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(String.format("Movie: %s | Time: %s", titles.get(i), times.get(i)));
        }
    }

    // convert list to array for report
    public void printReport() {
        String[] titleArray = titles.toArray(new String[0]);
        String[] timeArray = times.toArray(new String[0]);

        System.out.println("---- Movie Report ----");
        for (int i = 0; i < titleArray.length; i++) {
            System.out.println(titleArray[i] + " - " + timeArray[i]);
        }
    }

    // main method (testing)
    public static void main(String[] args) {
        CinemaTime ct = new CinemaTime();

        try {
            ct.addMovie("Avengers", "18:30");
            ct.addMovie("Inception", "21:15");
            // ct.addMovie("WrongTime", "25:99"); // exception example
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        ct.displayAllMovies();
        ct.searchMovie("Av");
        ct.printReport();
    }
}
