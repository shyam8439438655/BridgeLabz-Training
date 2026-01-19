import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearch {

    // Linear search in array (O(N))
    static boolean searchArray(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 1_000_000;
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = N - 1; 

        //  Array Search
        long start = System.currentTimeMillis();
        boolean foundArray = searchArray(array, target);
        long end = System.currentTimeMillis();
        System.out.println("Array Search Found? " + foundArray);
        System.out.println("Array Search Time: " + (end - start) + " ms");

        //  HashSet Search 
        start = System.currentTimeMillis();
        boolean foundHashSet = hashSet.contains(target);
        end = System.currentTimeMillis();
        System.out.println("HashSet Search Found? " + foundHashSet);
        System.out.println("HashSet Search Time: " + (end - start) + " ms");

        // TreeSet Search 
        start = System.currentTimeMillis();
        boolean foundTreeSet = treeSet.contains(target);
        end = System.currentTimeMillis();
        System.out.println("TreeSet Search Found? " + foundTreeSet);
        System.out.println("TreeSet Search Time: " + (end - start) + " ms");
    }
}
