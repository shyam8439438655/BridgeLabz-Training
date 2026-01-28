import java.util.*;

class RestaurantReservationSystem {

    // custom exception
    static class TableAlreadyReservedException extends Exception {
        TableAlreadyReservedException(String msg) {
            super(msg);
        }
    }

    // tableNumber -> timeSlot
    static Map<Integer, String> tableMap = new HashMap<>();

    // reserve table
    static void reserveTable(int tableNo, String time)
            throws TableAlreadyReservedException {

        if (tableMap.containsKey(tableNo) && tableMap.get(tableNo).equals(time)) {
            throw new TableAlreadyReservedException("Table already reserved!");
        }

        tableMap.put(tableNo, time);
        System.out.println("Table " + tableNo + " reserved for " + time);
    }

    // cancel reservation
    static void cancelReservation(int tableNo) {
        tableMap.remove(tableNo);
        System.out.println("Reservation cancelled for table " + tableNo);
    }

    // show available tables
    static void showAvailableTables(int totalTables, String time) {
        System.out.println("Available tables at " + time + ":");
        for (int i = 1; i <= totalTables; i++) {
            if (!tableMap.containsKey(i) || !tableMap.get(i).equals(time)) {
                System.out.println("Table " + i);
            }
        }
    }

    public static void main(String[] args) {

        try {
            reserveTable(1, "7PM");
            reserveTable(2, "7PM");

            
            reserveTable(1, "7PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        showAvailableTables(3, "7PM");

        cancelReservation(1);

        showAvailableTables(3, "7PM");
    }
}
