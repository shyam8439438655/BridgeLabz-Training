import java.time.*;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiry;

    Member(String name, LocalDate expiry) {
        this.name = name;
        this.expiry = expiry;
    }
}

public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("John", LocalDate.now().plusDays(10)),
            new Member("Sara", LocalDate.now().plusDays(40))
        );

        members.stream()
               .filter(m -> m.expiry.isBefore(LocalDate.now().plusDays(30)))
               .forEach(m -> System.out.println(m.name + " expires on " + m.expiry));
    }
}