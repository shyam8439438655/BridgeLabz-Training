import java.util.*;

public class SmartWarehouse {

    // Parent class
    abstract static class WarehouseItem {
        String name;

        WarehouseItem(String name) {
            this.name = name;
        }

        abstract void showDetails();
    }

    // Child classes
    static class Electronics extends WarehouseItem {
        Electronics(String name) {
            super(name);
        }

        public void showDetails() {
            System.out.println("Electronics Item: " + name);
        }
    }

    static class Groceries extends WarehouseItem {
        Groceries(String name) {
            super(name);
        }

        public void showDetails() {
            System.out.println("Grocery Item: " + name);
        }
    }

    static class Furniture extends WarehouseItem {
        Furniture(String name) {
            super(name);
        }

        public void showDetails() {
            System.out.println("Furniture Item: " + name);
        }
    }

    // Generic Storage class with bounded type
    static class Storage<T extends WarehouseItem> {
        private List<T> items = new ArrayList<>();

        public void addItem(T item) {
            items.add(item);
        }

        public List<T> getItems() {
            return items;
        }

        // Wildcard method
        public static void displayAllItems(List<? extends WarehouseItem> list) {
            for (WarehouseItem item : list) {
                item.showDetails();
            }
        }
    }

    
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics:");
        Storage.displayAllItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        Storage.displayAllItems(groceryStorage.getItems());

        System.out.println("\nFurniture:");
        Storage.displayAllItems(furnitureStorage.getItems());
    }
}
