package AI_Driven_Resume_Screening_System;

// Class for Software Engineer implementing JobRole interface
public class SoftwareEngineer implements JobRole {
    String candidateName;
    int codingScore; // 0-100

    public SoftwareEngineer(String candidateName, int codingScore) {
        this.candidateName = candidateName;
        this.codingScore = codingScore;
    }

    public String getRoleName() {
        return "Software Engineer";
    }
}

