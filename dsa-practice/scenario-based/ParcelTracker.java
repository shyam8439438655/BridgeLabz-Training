class ParcelTracker {

    // Node for Linked List
    class Node {
        String stage;
        Node next;

        Node(String stage) {
            this.stage = stage;
            this.next = null;
        }
    }

    Node head; // first stage

    // start tracking 
    void start(String stage) {
        head = new Node(stage);
    }

    // next stage add
    void addStage(String stage) {
        if (head == null) {
            System.out.println("Parcel missing (no start stage)");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(stage);
    }

    // custom checkpoint add
    void addCheckpoint(String afterStage, String newStage) {
        Node temp = head;

        while (temp != null && !temp.stage.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found, parcel lost");
            return;
        }

        Node node = new Node(newStage);
        node.next = temp.next;
        temp.next = node;
    }

    // forward tracking
    void trackParcel() {
        if (head == null) {
            System.out.println("Parcel missing (null)");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // main
    public static void main(String[] args) {
        ParcelTracker p = new ParcelTracker();

        p.start("Packed");
        p.addStage("Shipped");
        p.addStage("In Transit");
        p.addStage("Delivered");

        p.trackParcel();

        p.addCheckpoint("Shipped", "Custom Check");
        p.trackParcel();
    }
}
