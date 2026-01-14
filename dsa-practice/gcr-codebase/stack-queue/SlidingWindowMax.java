import java.util.*;

class SlidingWindowMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        // Input array
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Window size
        int k = input.nextInt();

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove out-of-window index
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Print max
            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
            input.close();
        }
    }
}
