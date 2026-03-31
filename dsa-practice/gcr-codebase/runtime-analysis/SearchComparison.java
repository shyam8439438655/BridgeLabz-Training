import java.util.Arrays;

public class SearchComparison {

    // Linear Search O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search O(log N)
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[1_000_000];
        for (int i = 0; i < data.length; i++)
            data[i] = i;

        int target = 999999;

        long start = System.nanoTime();
        linearSearch(data, target);
        System.out.println("Linear Search Time: " + (System.nanoTime() - start));

        Arrays.sort(data);
        start = System.nanoTime();
        binarySearch(data, target);
        System.out.println("Binary Search Time: " + (System.nanoTime() - start));
    }
}