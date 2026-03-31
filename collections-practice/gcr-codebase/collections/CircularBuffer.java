public class CircularBuffer {

    static class MyCircularBuffer {
        int[] arr;
        int size;
        int start = 0;   // points to oldest
        int count = 0;   // how many elements currently

        MyCircularBuffer(int size) {
            this.size = size;
            arr = new int[size];
        }

        void insert(int x) {
            if (count < size) {
                arr[(start + count) % size] = x;
                count++;
            } else {
                // overwrite oldest
                arr[start] = x;
                start = (start + 1) % size;
            }
        }

        void printBuffer() {
            System.out.print("[");
            for (int i = 0; i < count; i++) {
                System.out.print(arr[(start + i) % size]);
                if (i != count - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        MyCircularBuffer cb = new MyCircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer(); // [1, 2, 3]

        cb.insert(4);
        cb.printBuffer(); // [2, 3, 4]
    }
}
