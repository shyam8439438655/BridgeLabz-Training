import java.util.LinkedList;
import java.util.Queue;

// vehicle node for circular linked list
class Vehicle {
    int number;
    Vehicle next;

    // constructor
    Vehicle(int number) {
        this.number = number;
        next = null;
    }
}

// roundabout logic
class Roundabout {
    Vehicle head = null;   // starting point of roundabout

    // add vehicle in circular path
    void addVehicle(int number) {
        Vehicle newVehicle = new Vehicle(number);

        // if roundabout is empty
        if (head == null) {
            head = newVehicle;
            newVehicle.next = head; // pointing to itself
        } 
        // if vehicles already present
        else {
            Vehicle temp = head;

            // reach last vehicle
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newVehicle;
            newVehicle.next = head;
        }
        System.out.println("Vehicle " + number + " entered roundabout");
    }

    // remove vehicle from roundabout
    void removeVehicle() {

        // if no vehicle present
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        // only one vehicle
        if (head.next == head) {
            System.out.println("Vehicle " + head.number + " exited");
            head = null;
            return;
        }

        // more than one vehicle
        Vehicle temp = head;

        // go to last vehicle
        while (temp.next != head) {
            temp = temp.next;
        }

        System.out.println("Vehicle " + head.number + " exited");
        temp.next = head.next;
        head = head.next;
    }

    // print current roundabout
    void printRoundabout() {

        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        Vehicle temp = head;
        System.out.print("Roundabout: ");

        // loop till we come back to start
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to start)");
    }
}

// main class
public class TrafficManager {

    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        Queue<Integer> waitingQueue = new LinkedList<>();

        int MAX_QUEUE = 3;  // max vehicles allowed in queue

        // vehicles coming to roundabout
        addToQueue(waitingQueue, MAX_QUEUE, 101);
        addToQueue(waitingQueue, MAX_QUEUE, 102);
        addToQueue(waitingQueue, MAX_QUEUE, 103);
        addToQueue(waitingQueue, MAX_QUEUE, 104); // overflow case

        // move vehicles from queue to roundabout
        if (!waitingQueue.isEmpty())
            roundabout.addVehicle(waitingQueue.poll());

        if (!waitingQueue.isEmpty())
            roundabout.addVehicle(waitingQueue.poll());

        roundabout.printRoundabout();

        // one vehicle exits
        roundabout.removeVehicle();
        roundabout.printRoundabout();
    }

    // queue overflow check
    static void addToQueue(Queue<Integer> q, int limit, int vehicle) {

        // if queue is full
        if (q.size() == limit) {
            System.out.println("Queue Overflow! Vehicle " + vehicle + " waiting");
        } 
        // if space available
        else {
            q.add(vehicle);
            System.out.println("Vehicle " + vehicle + " added to queue");
        }
    }
}
