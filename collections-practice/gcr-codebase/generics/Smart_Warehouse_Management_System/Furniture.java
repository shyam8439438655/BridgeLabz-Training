package Smart_Warehouse_Management_System;
// Furniture.java
public class Furniture implements Item {
    String name;

    public Furniture(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Furniture Item: " + name);
    }
}

