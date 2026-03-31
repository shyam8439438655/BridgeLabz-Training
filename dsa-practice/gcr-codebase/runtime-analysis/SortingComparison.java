import java.util.Arrays;

public class SortingComparison {

    // Bubble Sort O(N²)
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    // Merge Sort O(N log N)
    static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = new int[10_000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 10000);

        int[] copy1 = arr.clone();
        int[] copy2 = arr.clone();

        long start = System.currentTimeMillis();
        bubbleSort(copy1);
        System.out.println("Bubble Sort Time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        mergeSort(copy2);
        System.out.println("Merge Sort Time: " + (System.currentTimeMillis() - start));
    }
}