package Dynamic_Online_Marketplace_System;

// ClothingCategory.java
public class ClothingCategory implements Category {
    String name;

    public ClothingCategory(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }
}

