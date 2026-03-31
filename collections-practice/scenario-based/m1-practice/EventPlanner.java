import java.util.*;

abstract class Festival {
    String name;
    String location;
    String date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void display();
}

class MusicFestival extends Festival {
    String headliner;
    String musicGenre;
    int ticketPrice;

    MusicFestival(String name, String location, String date,
                  String headliner, String musicGenre, int ticketPrice) {

        super(name, location, date);
        this.headliner = headliner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + musicGenre);
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int numStalls;
    int entryFee;

    FoodFestival(String name, String location, String date,
                 String cuisine, int numStalls, int entryFee) {

        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
    }
}

class ArtFestival extends Festival {
    String artType;
    int numArtists;
    int exhibitionFee;

    ArtFestival(String name, String location, String date,
                String artType, int numArtists, int exhibitionFee) {

        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: " + exhibitionFee);
    }
}

public class EventPlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Festival> map = new HashMap<>();

        while (true) {

            String line = sc.nextLine();

            if (line.equals("EXIT"))
                break;

            String[] p = line.split(" ");

            if (p[0].equals("ADD_FESTIVAL")) {

                String type = p[1];

                if (type.equals("MUSIC")) {

                    Festival f = new MusicFestival(
                            p[2], p[3], p[4], p[5], p[6],
                            Integer.parseInt(p[7])
                    );

                    map.put(p[2], f);
                }

                else if (type.equals("FOOD")) {

                    Festival f = new FoodFestival(
                            p[2], p[3], p[4], p[5],
                            Integer.parseInt(p[6]),
                            Integer.parseInt(p[7])
                    );

                    map.put(p[2], f);
                }

                else if (type.equals("ART")) {

                    Festival f = new ArtFestival(
                            p[2], p[3], p[4], p[5],
                            Integer.parseInt(p[6]),
                            Integer.parseInt(p[7])
                    );

                    map.put(p[2], f);
                }
            }

            else if (p[0].equals("DISPLAY_DETAILS")) {

                String name = p[1];

                if (map.containsKey(name))
                    map.get(name).display();
            }
        }
    }
}