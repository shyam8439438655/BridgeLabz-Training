import java.util.*;

public class EmailNotifications {
    public static void sendEmailNotification(String email) {
        System.out.println("Sending email to: " + email);
    }

    public static void main(String[] args) {
        List<String> emails = Arrays.asList("user1@gmail.com", "user2@gmail.com");
        emails.forEach(email -> sendEmailNotification(email));
    }
}