import java.util.Scanner;

class Merge {

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int m = (left + right) / 2;

        mergeSort(arr, left, m);
        mergeSort(arr, m + 1, right);

        int[] temp = new int[right - left + 1];
        int i = left, j = m + 1, k = 0;

        while (i <= m && j <= right) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
