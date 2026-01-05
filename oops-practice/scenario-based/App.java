public class App {

    // Method to parse the invoice string into individual tasks
    public static String[] ParseInvoice(String input) {
        // Split tasks by comma
        String[] tasks = input.split(",");
        return tasks;
    }

    // Method to calculate total amount from tasks
    public static int GetTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            // Trim spaces around each task
            task = task.trim();

            // Split task into name and amount
            String[] parts = task.split("-");

            String taskName = parts[0].trim();   // e.g. "Logo Design"
            String amountStr = parts[1].trim();  // e.g. "3000 INR"

            // Remove "INR" and extra spaces
            amountStr = amountStr.replace("INR", "").trim();

            // Convert string to integer
            int amount = Integer.parseInt(amountStr);

            // Add to total
            total += amount;

            // Print each task for clarity
            System.out.println("Task: " + taskName + ", Amount: " + amount);
        }

        return total;
    }

    // Main method to test the program
    public static void main(String[] args) {
        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        // Step 1: Parse invoice
        String[] tasks = ParseInvoice(input);

        // Step 2: Calculate total
        int total = GetTotalAmount(tasks);

        // Step 3: Print total
        System.out.println("Total Invoice Amount: " + total + " INR");
    }
}