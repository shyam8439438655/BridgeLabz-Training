package Dynamic_Online_Marketplace_System;

// BookCategory.java
public class BookCategory implements Category {
    String name;

    public BookCategory(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }
}

