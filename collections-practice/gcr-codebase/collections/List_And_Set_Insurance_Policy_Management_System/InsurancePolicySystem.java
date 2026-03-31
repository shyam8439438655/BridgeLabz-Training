package List_And_Set_Insurance_Policy_Management_System;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicySystem {

    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        // Sample input (with duplicates)
        List<Policy> input = Arrays.asList(
                new Policy("P101", "Amit", LocalDate.now().plusDays(20), "Health", 5000),
                new Policy("P102", "Neha", LocalDate.now().plusDays(10), "Auto", 3200),
                new Policy("P103", "Ravi", LocalDate.now().plusDays(60), "Home", 4500),
                new Policy("P102", "NehaX", LocalDate.now().plusDays(15), "Auto", 3300),
                new Policy("P104", "Sita", LocalDate.now().plusDays(5), "Health", 2800),
                new Policy("P101", "AmitY", LocalDate.now().plusDays(25), "Health", 5100)
        );

        // Add all policies
        for (Policy p : input) {
            manager.addPolicy(p);
        }

        // 1) Show all unique policies
        manager.showAllPolicies();

        // 2) Show policies expiring soon
        manager.showExpiringSoon();

        // 3) Show policies by coverage type
        manager.showByCoverage("Health");

        // 4) Show duplicate policies
        manager.showDuplicates(input);

        // 5) Simple performance test
        List<Policy> bigList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            bigList.add(new Policy("PX" + i, "User" + i,
                    LocalDate.now().plusDays(i % 365),
                    "Auto", 1000));
        }

        manager.performanceTest(bigList);
    }
}

