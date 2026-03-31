import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        Queue<Integer> rev = new LinkedList<>();

        while (!q.isEmpty()) {
            int x = q.remove();

            int size = rev.size();
            rev.add(x);

    
            for (int i = 0; i < size; i++) {
                rev.add(rev.remove());
            }
        }

        System.out.println(rev); // [30, 20, 10]
    }
}
