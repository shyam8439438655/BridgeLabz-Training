package AI_Driven_Resume_Screening_System;

// class for Product Manager implementing JobRole interface
public class ProductManager implements JobRole {
    String candidateName;
    int communicationScore; // 0-100

    public ProductManager(String candidateName, int communicationScore) {
        this.candidateName = candidateName;
        this.communicationScore = communicationScore;
    }

    public String getRoleName() {
        return "Product Manager";
    }
}

