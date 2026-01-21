package Smart_Warehouse_Management_System;

// Storage.java
import java.util.ArrayList;
import java.util.List;

public class Storage<T extends Item> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    // Wildcard method
    public static void displayAllItems(List<? extends Item> list) {
        for (Item item : list) {
            item.showDetails();
        }
    }
}

