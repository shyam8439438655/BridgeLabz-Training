import java.util.*;

public class BinaryNumbersQueue {
    public static void main(String[] args) {
        int n = 5;

        Queue<String> q = new LinkedList<>();
        List<String> ans = new ArrayList<>();

        q.add("1");

        for (int i = 0; i < n; i++) {
            String s = q.remove();
            ans.add(s);

            q.add(s + "0");
            q.add(s + "1");
        }

        System.out.println(ans); // [1, 10, 11, 100, 101]
    }
}
