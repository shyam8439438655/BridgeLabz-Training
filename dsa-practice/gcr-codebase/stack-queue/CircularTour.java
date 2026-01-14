import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class CircularTour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        // petrol at each pump
        for (int i = 0; i < n; i++) {
            petrol[i] = input.nextInt();
        }

        // distance to next pump
        for (int i = 0; i < n; i++) {
            distance[i] = input.nextInt();
        }

        Queue<Integer> q = new LinkedList<>();
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {

            // add current pump to tour
            q.add(i);
            surplus += petrol[i] - distance[i];

            // if petrol becomes insufficient, remove from front
            while (surplus < 0 && !q.isEmpty()) {
                int removed = q.poll();
                surplus -= petrol[removed] - distance[removed];
                start = removed + 1;
            }
        }

        // if queue contains all pumps → circular tour possible
        if (q.size() == n) {
            System.out.println(start);
        } else {
            System.out.println(-1);
        }
        input.close();
    }
}