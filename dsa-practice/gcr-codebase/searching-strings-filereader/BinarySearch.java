import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number Of Element");
        int n = sc.nextInt();

        System.out.println("Enter Element");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enetr The Key");
        int key = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int mid = 0;
        boolean found = false;

        
        for (; low <= high; ) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Found at index: " + mid);
                found = true;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        
        if (!found) {
            System.out.println("Not found");
        }
    }
}
