package Smart_University_Library_Management_System;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Singleton catalog = Singleton.getInstance();

        User s1 = Factory.createUser("student", "Aman", "Data Structures");
        User f1 = Factory.createUser("faculty", "Dr. Sharma", "Data Structures");

        catalog.addObserver((Observer) s1);
        catalog.addObserver((Observer) f1);

        Builder book = new Builder.BookBuilder("Data Structures")
                .authors(Arrays.asList("Cormen"))
                .edition("3rd")
                .genre("CS")
                .publisher("MIT Press")
                .build();

        catalog.addBook(book);
    }
}
