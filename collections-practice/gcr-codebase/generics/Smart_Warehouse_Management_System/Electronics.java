package Smart_Warehouse_Management_System;

// Electronics.java
public class Electronics implements Item {
    String name;

    public Electronics(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Electronics Item: " + name);
    }
}

