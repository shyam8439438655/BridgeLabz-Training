import java.util.*;

public class EventAttendeeWelcomeMessage {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Nicky", "Roma", "Alex");
        attendees.forEach(a -> System.out.println("Welcome " + a + "!"));
    }
}