class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    Ticket next;   // circular link

    // Constructor
    Ticket(int ticketId, String customerName, String movieName,
           String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;

    //  Add ticket at end
    void addTicket(int id, String customer, String movie,
                   String seat, String time) {

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;   // circular
            return;
        }

        Ticket temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTicket;
        newTicket.next = head;
    }

    //  Remove ticket by Ticket ID
    void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        do {
            if (temp.ticketId == id) {

                // only one ticket
                if (temp.next == head && prev == null) {
                    head = null;
                }
                // removing head ticket
                else if (temp == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                // removing middle/last ticket
                else {
                    prev.next = temp.next;
                }

                System.out.println("Ticket removed successfully");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Ticket not found");
    }

    //  Display all tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        System.out.println("Booked Tickets:");
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    //  Search ticket by Customer Name
    void searchByCustomer(String customer) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customer)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this customer");
    }

    //  Search ticket by Movie Name
    void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this movie");
    }

    //  Count total tickets
    void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets = 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets = " + count);
    }

    void printTicket(Ticket t) {
        System.out.println("------------------------");
        System.out.println("Ticket ID     : " + t.ticketId);
        System.out.println("Customer Name : " + t.customerName);
        System.out.println("Movie Name    : " + t.movieName);
        System.out.println("Seat Number   : " + t.seatNumber);
        System.out.println("Booking Time  : " + t.bookingTime);
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {

        TicketReservationSystem trs = new TicketReservationSystem();

        trs.addTicket(1, "Aman", "Inception", "A1", "10:00 AM");
        trs.addTicket(2, "Ravi", "Inception", "A2", "10:05 AM");
        trs.addTicket(3, "Neha", "Avatar", "B1", "10:10 AM");

        trs.displayTickets();

        trs.searchByCustomer("Aman");
        trs.searchByMovie("Inception");

        trs.countTickets();

        trs.removeTicket(2);

        trs.displayTickets();
        trs.countTickets();
    }
}
