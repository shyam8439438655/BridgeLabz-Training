import java.util.HashMap;
import java.util.Scanner;

class TwoSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int target = input.nextInt();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int need = target - arr[i];

            if (map.containsKey(need)) {
                System.out.println(map.get(need) + " " + i);
                return;
            }
            map.put(arr[i], i);
        }

        System.out.println("No pair found");
    }
}
