class RoomNotAvailableException extends RuntimeException {
    public RoomNotAvailableException(String msg){
        super(msg);
    }
 }

interface PricingStrategy{
    double calculatePrice(int days);
}

class Room {
    private int roomId;
    protected boolean isAvailable = true;

    Room(int roomId){
        this.roomId = roomId;
    }

    // for CheckIn
    public void checkIn() throws RoomNotAvailableException{
        if(!isAvailable){
            throw new RoomNotAvailableException("Room is not Available");
        }
        isAvailable = false;
        System.out.println("CheckIn Successfull for Room" + roomId);
    }

    // for checkout
    public void checkOut() throws RoomNotAvailableException{
        isAvailable = true;
        System.out.println("Checkout Successfull for Room" + roomId);
    }
}

// Inheritance From Room

class DeluxeRoom extends Room implements PricingStrategy {

    DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 2000;
    }
}

// Inheritance from Room
class StandardRoom extends Room implements PricingStrategy {

    StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 1000;
    }

}

class Guest {
    private String name;

    Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private Guest guest;
    PricingStrategy room;
    private int days;

    Reservation(Guest guest, PricingStrategy room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }

    public void generateBill() {
        double amount = room.calculatePrice(days);
        System.out.println("Guest: " + guest.getName());
        System.out.println("Total Bill: ₹" + amount);
    }
}


public class HotelReservationSystem {
    public static void main(String[] args) throws RoomNotAvailableException {
        Guest g1 = new Guest("Prince");
        Room room1 = new StandardRoom(101);
        
        PricingStrategy pricing1 = (PricingStrategy) room1;
        
        try {
            room1.checkIn();
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        
        Reservation r1 = new Reservation(g1, pricing1, 3);
        r1.generateBill();
        room1.checkOut();

        System.out.println("      ");
        Room room2 = new DeluxeRoom(102); 

        PricingStrategy pricing2 = (PricingStrategy) room2;

        try {
            room2.checkIn();
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        Reservation r2 = new Reservation(g1, pricing2, 3);
        r2.generateBill();
        room2.checkOut();
    }
}
