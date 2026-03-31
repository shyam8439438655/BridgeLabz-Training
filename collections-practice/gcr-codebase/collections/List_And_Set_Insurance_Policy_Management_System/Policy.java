package List_And_Set_Insurance_Policy_Management_System;

import java.time.LocalDate;
import java.util.Objects;

public class Policy {
    final String policyNumber;
    private final String policyholderName;
    private final LocalDate expiryDate;
    final String coverageType;
    private final double premiumAmount;

    public Policy(String policyNumber, String policyholderName,
                  LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    // Unique by policy number
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "no='" + policyNumber + '\'' +
                ", name='" + policyholderName + '\'' +
                ", expiry=" + expiryDate +
                ", type='" + coverageType + '\'' +
                ", premium=" + premiumAmount +
                '}';
    }
}

