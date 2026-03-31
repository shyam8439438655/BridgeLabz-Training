package Dynamic_Online_Marketplace_System;

// GadgetCategory.java
public class GadgetCategory implements Category {
    String name;

    public GadgetCategory(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }
}

