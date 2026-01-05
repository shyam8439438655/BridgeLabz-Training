import java.util.Scanner;

public class CafeteriaMenuApp {

    // Method to display the menu
    public static void DisplayMenu(String[] menu) {
        System.out.println("Campus Cafeteria Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + " : " + menu[i]);
        }
        System.out.println("-------------------------------");
    }

    // Method to get item by index
    public static String GetItemByIndex(String[] menu, int index) {
        if (index >= 0 && index < menu.length) {
            return menu[index];
        } else {
            return "Invalid selection!";
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fixed 10 items in cafeteria
        String[] menu = {
            "Veg Sandwich",
            "Cheese Pizza",
            "Pasta",
            "Burger",
            "French Fries",
            "Cold Coffee",
            "Hot Tea",
            "Paneer Roll",
            "Chocolate Muffin",
            "Fruit Salad"
        };

        //  Display menu
        DisplayMenu(menu);

        // Take user input
        System.out.print("Enter the index of the item you want to order: ");
        int choice = sc.nextInt();

        // Get item by index
        String selectedItem = GetItemByIndex(menu, choice);

        // Show result
        System.out.println("You selected: " + selectedItem);

        sc.close();
    }
}