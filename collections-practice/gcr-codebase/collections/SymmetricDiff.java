import java.util.*;

public class SymmetricDiff{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);              // Union
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);           // Intersection
        result.removeAll(common);         // Remove common from union

        System.out.println(result);
    }
}
