class HashMap {

    class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int SIZE = 10;
    private Node[] table;

    HashMap() {
        table = new Node[SIZE];
    }

    // Hash function
    private int hash(int key) {
        return key % SIZE;
    }

    void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        // Update if key exists
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    // GET
    int get(int key) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return -1; // not found
    }

    // REMOVE
    void remove(int key) {
        int index = hash(key);
        Node head = table[index];
        Node prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    // Test
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(12, 30); // collision handled

        System.out.println(map.get(1));  // 10
        System.out.println(map.get(12)); // 30

        map.remove(2);
        System.out.println(map.get(2));  // -1
    }
}
