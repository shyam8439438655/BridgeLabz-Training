import java.util.*;

class PairWithSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int target = input.nextInt();

        HashSet<Integer> set = new HashSet<>();
        boolean found = false;

        for (int num : arr) {
            int need = target - num;

            if (set.contains(need)) {
                System.out.println("Yes");
                found = true;
                break;
            }
            set.add(num);
        }

        if (!found) {
            System.out.println("No");
        }
        input.close();
    }
}
