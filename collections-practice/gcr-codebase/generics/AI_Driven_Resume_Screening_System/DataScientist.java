package AI_Driven_Resume_Screening_System;

// class for Data Scientist implementing JobRole interface
public class DataScientist implements JobRole {
    String candidateName;
    int mlScore; // 0-100

    public DataScientist(String candidateName, int mlScore) {
        this.candidateName = candidateName;
        this.mlScore = mlScore;
    }

    public String getRoleName() {
        return "Data Scientist";
    }
}

