package List_And_Set_Insurance_Policy_Management_System;


import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();

    // TreeSet sorted by expiry date
    Set<Policy> treeSet = new TreeSet<>(new Comparator<Policy>() {
        public int compare(Policy a, Policy b) {
            int x = a.getExpiryDate().compareTo(b.getExpiryDate());
            if (x == 0) {
                return a.policyNumber.compareTo(b.policyNumber);
            }
            return x;
        }
    });

    // Add policy to all sets
    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    // Show all policies
    public void showAllPolicies() {
        System.out.println("\n--- HashSet ---");
        for (Policy p : hashSet) System.out.println(p);

        System.out.println("\n--- LinkedHashSet (Insertion Order) ---");
        for (Policy p : linkedHashSet) System.out.println(p);

        System.out.println("\n--- TreeSet (Sorted by Expiry Date) ---");
        for (Policy p : treeSet) System.out.println(p);
    }

    // Policies expiring in next 30 days
    public void showExpiringSoon() {
        System.out.println("\n--- Policies Expiring in Next 30 Days ---");
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Policy p : treeSet) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                System.out.println(p);
            }
        }
    }

    // Policies by coverage type
    public void showByCoverage(String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // Find duplicate policies from original list
    public void showDuplicates(List<Policy> input) {
        System.out.println("\n--- Duplicate Policies (By Policy Number) ---");

        Set<String> seen = new HashSet<>();
        Set<String> dup = new HashSet<>();

        for (Policy p : input) {
            if (!seen.add(p.policyNumber)) {
                dup.add(p.policyNumber);
            }
        }

        for (Policy p : input) {
            if (dup.contains(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }

    // Simple performance check
    public void performanceTest(List<Policy> bigList) {
        System.out.println("\n--- Performance Test ---");

        Policy target = bigList.get(bigList.size() / 2);

        long start, end;

        // HashSet
        start = System.nanoTime();
        Set<Policy> hs = new HashSet<>(bigList);
        end = System.nanoTime();
        System.out.println("HashSet add: " + (end - start));

        start = System.nanoTime();
        hs.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet search: " + (end - start));

        // LinkedHashSet
        start = System.nanoTime();
        Set<Policy> lhs = new LinkedHashSet<>(bigList);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add: " + (end - start));

        start = System.nanoTime();
        lhs.contains(target);
        end = System.nanoTime();
        System.out.println("LinkedHashSet search: " + (end - start));

        // TreeSet
        start = System.nanoTime();
        Set<Policy> ts = new TreeSet<>(((TreeSet<Policy>) treeSet).comparator());
        ts.addAll(bigList);
        end = System.nanoTime();
        System.out.println("TreeSet add: " + (end - start));

        start = System.nanoTime();
        ts.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet search: " + (end - start));
    }
}
