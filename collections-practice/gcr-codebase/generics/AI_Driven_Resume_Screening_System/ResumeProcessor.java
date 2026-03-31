package AI_Driven_Resume_Screening_System;

// class for ResumeProcessor with generic method to process resumes
public class ResumeProcessor {

    // Generic method (process any resume type safely)
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        resume.showResume();

        // role-wise basic screening logic
        if (resume.getRoleData() instanceof SoftwareEngineer) {
            SoftwareEngineer se = (SoftwareEngineer) resume.getRoleData();
            System.out.println("Candidate: " + se.candidateName + " | Coding Score: " + se.codingScore);
            System.out.println(se.codingScore >= 60 ? "Status: Shortlisted" : "Status: Rejected");
        }

        else if (resume.getRoleData() instanceof DataScientist) {
            DataScientist ds = (DataScientist) resume.getRoleData();
            System.out.println("Candidate: " + ds.candidateName + " | ML Score: " + ds.mlScore);
            System.out.println(ds.mlScore >= 65 ? "Status: Shortlisted" : "Status: Rejected");
        }

        else if (resume.getRoleData() instanceof ProductManager) {
            ProductManager pm = (ProductManager) resume.getRoleData();
            System.out.println("Candidate: " + pm.candidateName + " | Communication Score: " + pm.communicationScore);
            System.out.println(pm.communicationScore >= 70 ? "Status: Shortlisted" : "Status: Rejected");
        }

        System.out.println("_____________");
    }
}

