package Smart_Warehouse_Management_System;

// Groceries.java
public class Groceries implements Item {
    String name;

    public Groceries(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Grocery Item: " + name);
    }
}

