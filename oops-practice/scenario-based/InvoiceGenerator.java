// Custom Exception Class
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {

    // Method to parse invoice string into tasks
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input cannot be empty!");
        }

        // Split tasks by comma
        String[] tasks = input.split(",");

        // Check if each task has a dash "-"
        for (String task : tasks) {
            if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException("Invalid format: missing '-' in task -> " + task);
            }
        }

        return tasks;
    }

    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;

        for (String task : tasks) {
            task = task.trim(); // remove extra spaces

            // Split into name and amount
            String[] parts = task.split("-");
            if (parts.length < 2) {
                throw new InvalidInvoiceFormatException("Invalid format for task: " + task);
            }

            String taskName = parts[0].trim();   // e.g. "Logo Design"
            String amountStr = parts[1].trim();  // e.g. "3000 INR"

            // Must contain INR
            if (!amountStr.contains("INR")) {
                throw new InvalidInvoiceFormatException("Missing 'INR' in task: " + task);
            }

            // Remove INR and spaces
            amountStr = amountStr.replace("INR", "").trim();

            // Convert to integer
            int amount;
            try {
                amount = Integer.parseInt(amountStr);
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException("Invalid number in task: " + task);
            }

            // Print each task
            System.out.println("Task: " + taskName + ", Amount: " + amount);

            total += amount;
        }

        return total;
    }

    // Main method
    public static void main(String[] args) {
        
        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        try {
            //  Parse invoice
            String[] tasks = parseInvoice(input);

            // Calculate total
            int total = getTotalAmount(tasks);

            // Print total
            System.out.println("Total Invoice Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}