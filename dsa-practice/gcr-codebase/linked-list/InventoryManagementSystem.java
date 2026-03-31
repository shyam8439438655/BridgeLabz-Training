class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;

    Item next;

    // Constructor
    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    //  Add item at beginning
    void addAtBeginning(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    //  Add item at end
    void addAtEnd(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    //  Add item at specific position (1-based)
    void addAtPosition(int position, int id, String name, int qty, double price) {
        if (position == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Item newItem = new Item(id, name, qty, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    //  Remove item by Item ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
        }
    }

    //  Update quantity by Item ID
    void updateQuantity(int id, int newQty) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    //  Search by Item ID
    void searchById(int id) {
        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    //  Search by Item Name
    void searchByName(String name) {
        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    //  Calculate total inventory value
    void calculateTotalValue() {
        Item temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    //  Sort by Item Name (Bubble Sort – Easy)
    void sortByName(boolean ascending) {
        if (head == null) return;

        Item i, j;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {

                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                    (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {

                    swapData(i, j);
                }
            }
        }
    }

    //  Sort by Price
    void sortByPrice(boolean ascending) {
        if (head == null) return;

        Item i, j;
        for (i = head; i.next != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {

                if ((ascending && i.price > j.price) ||
                    (!ascending && i.price < j.price)) {

                    swapData(i, j);
                }
            }
        }
    }

    // Swap item data 
    void swapData(Item a, Item b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    // Display all items
    void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory");
            return;
        }

        Item temp = head;
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    // Helper method
    void printItem(Item i) {
        System.out.println("--------------------");
        System.out.println("Item ID   : " + i.itemId);
        System.out.println("Item Name : " + i.itemName);
        System.out.println("Quantity  : " + i.quantity);
        System.out.println("Price     : " + i.price);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {

        Inventory inv = new Inventory();

        inv.addAtEnd(101, "Pen", 50, 10);
        inv.addAtEnd(102, "Notebook", 20, 50);
        inv.addAtBeginning(103, "Pencil", 100, 5);

        inv.displayAll();

        inv.updateQuantity(101, 60);
        inv.searchByName("Notebook");

        inv.calculateTotalValue();

        inv.sortByPrice(true); // ascending
        System.out.println("\nAfter Sorting by Price:");
        inv.displayAll();
    }
}
