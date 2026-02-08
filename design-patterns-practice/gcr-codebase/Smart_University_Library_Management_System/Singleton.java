package Smart_University_Library_Management_System;

import java.util.*;

// Singleton + Subject
public class Singleton {

    // -------- Singleton --------
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // -------- Observer --------
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String bookName) {
        for (Observer o : observers) {
            o.update(bookName);
        }
    }

    // -------- Catalog Action --------
    public void addBook(Builder book) {
        System.out.println("Book added: " + book.title);
        notifyObservers(book.title);
    }
}

// Observer Interface
interface Observer {
    void update(String bookName);
}
